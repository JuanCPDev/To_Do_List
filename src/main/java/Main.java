import entity.TodolistEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TodolistEntity toDoDB = new TodolistEntity();
            toDoDB.setTasks("clean room3");
            entityManager.persist(toDoDB);



            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }entityManager.close();
            entityManagerFactory.close();
        }
   }
}
