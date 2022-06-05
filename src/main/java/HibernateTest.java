import entity.Todolist;
import jakarta.persistence.*;


public class HibernateTest {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    public static void main(String[] args) {
        try {
            transaction.begin();
            //Todolist toDoDB = new Todolist();
            TypedQuery<Todolist> allTaskQuery = entityManager.createNamedQuery("listTasks", Todolist.class);

            for (Todolist tasks : allTaskQuery.getResultList()){
                System.out.println(tasks);
            }

          //  entityManager.persist(toDoDB);



            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }entityManager.close();
            entityManagerFactory.close();
        }
   }
}
