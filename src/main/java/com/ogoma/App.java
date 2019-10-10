package com.ogoma;

import com.ogoma.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //When not using hibernate.properties file use new Configuration().configure("hibernate.cfg.xml") ;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user
                .setEmail("ogoma.emmanuel@gmail.com")
                .setFirstName("Emmanuel")
                .setLastName("Ogoma")
                .setPassword("123");
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }finally {

        }

        System.out.println("Hello World!");
    }
}
