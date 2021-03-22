package com.sda.hibernate.associations.many_to_many;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDao {

    public void create(Post post) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(post);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Post findById(Long id) {
        Post result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.find(Post.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
