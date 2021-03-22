package com.sda.hibernate.associations.one_to_many_bi;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParentDao {

    public void create(Parent parent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(parent);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Parent findById(Long id) {
        Parent result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.find(Parent.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
