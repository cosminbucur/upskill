package com.sda.hibernate.types;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlayerDao {

    // create
    public void create(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(player);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    // find by id
    public Player findById(Long id) {
        Player result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(Player.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
