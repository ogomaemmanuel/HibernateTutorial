package com.ogoma;

import com.ogoma.entities.Role;
import com.ogoma.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //When not using hibernate.properties file use new Configuration().configure("hibernate.cfg.xml") ;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Role.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Role role = new Role();
        role.setName("Tester");
        role.setDescription("Responsible for testing applications");
        User user = new User();
        user
                .setEmail("ogoma.emmanuel+10@gmail.com")
                .setFirstName("Emmanuel")
                .setLastName("Ogoma")
                .setPassword("123");

        role.addUser(user);
        try {
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {

        }

        System.out.println("Hello World!");
    }
}
