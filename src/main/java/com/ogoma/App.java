package com.ogoma;

import com.ogoma.entities.Role;
import com.ogoma.entities.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;


/**
 * Hello world!
 */
public class App {
    //private static Logger logger= LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        //When not using hibernate.properties file use new Configuration().configure("hibernate.cfg.xml") ;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Role.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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
          //  logger.debug("User details saved");
        } catch (Exception e) {
            transaction.rollback();
        } finally {

        }
    }
}
