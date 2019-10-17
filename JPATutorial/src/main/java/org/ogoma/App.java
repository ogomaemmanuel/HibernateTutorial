package org.ogoma;

import org.ogoma.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-tuts");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Session session=entityManager.unwrap(Session.class);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User user = new User();
        user.setFirstName("Emmanuel");
        user.setLastName("Ogoma");
        user.setDob(new Date());
        entityManager.persist(user);
        entityTransaction.commit();
    }

}
