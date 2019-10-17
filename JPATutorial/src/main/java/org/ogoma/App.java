package org.ogoma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-tuts");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();
        entityTransaction.begin();

        entityTransaction.commit();

        System.out.println("Hello World!");
    }

}
