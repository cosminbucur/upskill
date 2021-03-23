package com.sda.hibernate.config;

import com.sda.hibernate.associations.many_to_many.Post;
import com.sda.hibernate.associations.many_to_many.Tag;
import com.sda.hibernate.associations.one_to_many_bi.Child;
import com.sda.hibernate.associations.one_to_many_bi.Parent;
import com.sda.hibernate.associations.one_to_many_uni.Daughter;
import com.sda.hibernate.associations.one_to_many_uni.Mother;
import com.sda.hibernate.associations.one_to_many_uni_join.Father;
import com.sda.hibernate.associations.one_to_many_uni_join.Son;
import com.sda.hibernate.associations.one_to_one.Account;
import com.sda.hibernate.associations.one_to_one.Employee;
import com.sda.hibernate.crud.Person;
import com.sda.hibernate.queries.hql.Stock;
import com.sda.hibernate.queries.native_query.Trader;
import com.sda.hibernate.types.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = createConfig();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        // set hibernate properties
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_tutorial?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "false");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");

        // crud
        configuration.addAnnotatedClass(Person.class);

        // types
        configuration.addAnnotatedClass(Player.class);

        // one to one
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Account.class);

        // one to many unidirectional
        configuration.addAnnotatedClass(Mother.class);
        configuration.addAnnotatedClass(Daughter.class);

        // one to many unidirectional join
        configuration.addAnnotatedClass(Father.class);
        configuration.addAnnotatedClass(Son.class);

        // one to many bidirectional
        configuration.addAnnotatedClass(Parent.class);
        configuration.addAnnotatedClass(Child.class);

        // many to many
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Tag.class);

        // native query
        configuration.addAnnotatedClass(Trader.class);

        // hql
        configuration.addAnnotatedClass(Stock.class);

        configuration.setProperties(properties);
        return configuration;
    }

}
