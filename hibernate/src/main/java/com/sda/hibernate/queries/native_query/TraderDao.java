package com.sda.hibernate.queries.native_query;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TraderDao {

    private static final Logger log = Logger.getLogger(TraderDao.class.getName());

    public void create(Trader trader) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(trader);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.severe("error creating trader :" + trader);
        }
    }

    public List<Trader> findAllWithNativeQuery() {
        List<Trader> result = new ArrayList<>();

        String sql = "SELECT * FROM trader";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // query using native sql
            NativeQuery<Trader> nativeQuery = session.createNativeQuery(sql, Trader.class);
            result = nativeQuery.list();

        } catch (HibernateException e) {
            log.severe("error executing sql :" + sql);
        }
        return result;
    }

    public List<Trader> findAllByNameWithNamedNativeQuery(String name) {
        List<Trader> result = new ArrayList<>();

        String nativeQueryName = "Trader.findByName";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // query using native sql
            Query<Trader> nativeQuery = session.createNamedQuery(nativeQueryName, Trader.class);
            nativeQuery.setParameter("name", name);

            result = nativeQuery.list();

        } catch (HibernateException e) {
            log.severe("error executing sql :" + nativeQueryName);
        }
        return result;
    }

}
