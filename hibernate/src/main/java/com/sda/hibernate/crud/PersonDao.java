package com.sda.hibernate.crud;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonDao {

    private static final Logger log = Logger.getLogger(PersonDao.class.getName());

    // crud
    public void create(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            // get session
            session = HibernateUtil.getSessionFactory().openSession();

            // create transaction
            transaction = session.beginTransaction();

            // execute query
            session.save(person);

            // commit
            transaction.commit();
        } catch (HibernateException e) {
            // if failed > rollback
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            // close transaction
            if (session != null) {
                session.close();
            }
        }
    }

    // find by id
    public Person findById(Long id) {
        Person result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(Person.class, id);
            if (result != null) {
                log.info("person found");
            }
        } catch (HibernateException e) {
            log.severe("failed to find person with id: " + id);
            e.printStackTrace();
        }
        return result;
    }

    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // HQL - hibernate query language
            Query<Person> query = session.createQuery("FROM Person", Person.class);
            result = query.getResultList();

            if (result != null) {
                log.info("people found");
            }
        } catch (HibernateException e) {
            log.severe("failed to find all");
            e.printStackTrace();
        }
        return result;
    }

    public void update(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(person);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(person);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
