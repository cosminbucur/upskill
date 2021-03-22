package com.sda.hibernate.associations.one_to_many_uni;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MotherDao {

    public void create(Mother mother) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(mother);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Mother findById(Long id) {
        Mother result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.find(Mother.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
