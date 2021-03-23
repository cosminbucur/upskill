package com.sda.hibernate.associations.one_to_one;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDao {

    public void create(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(account);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Account findById(Long id) {
        Account result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.find(Account.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
