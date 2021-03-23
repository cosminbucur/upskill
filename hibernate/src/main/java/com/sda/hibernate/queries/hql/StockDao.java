package com.sda.hibernate.queries.hql;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockDao {

    private static final Logger log = Logger.getLogger(StockDao.class.getName());

    public void create(Stock stock) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(stock);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.severe("error creating stock :" + stock);
        }
    }

    public List<Stock> findAllWithHqlQuery() {
        List<Stock> result = new ArrayList<>();

        String hql = "FROM com.sda.hibernate.queries.hql.Stock";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // query using hql
            TypedQuery<Stock> nativeQuery = session.createQuery(hql, Stock.class);
            result = nativeQuery.getResultList();

        } catch (HibernateException e) {
            log.severe("error executing hql :" + hql);
        }
        return result;
    }

    public List<Stock> findAllByStockCodeWithHqlQuery(String stockCode) {
        List<Stock> result = new ArrayList<>();

        String sql = "FROM Stock s WHERE s.code = :stockCode";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // query using hql
            TypedQuery<Stock> query = session.createQuery(sql, Stock.class);
            query.setParameter("stockCode", stockCode);

            result = query.getResultList();

        } catch (HibernateException e) {
            log.severe("error executing sql :" + sql);
        }
        return result;
    }

}
