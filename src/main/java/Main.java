import entity.Todolist;
import jakarta.persistence.*;

import java.util.Scanner;

public class Main {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    static Todolist taskList = new Todolist();

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("\nWelcome to your to-do List, please enter an option");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Print To-do List");
        System.out.println("4. Quit");

        option = input.nextInt();

        switch (option) {
            case 1:
                addItemMenu(input);
                break;
            case 2:
                removeItemMenu(input);
                break;
            case 3:
                printTasks();
                menu();
                break;
            case 4:
                entityManager.close();
                entityManagerFactory.close();
                System.out.println("Goodbye");

                return;

            default:
                System.out.println("Invalid entry\n");
                menu();
                break;
        }
    }

    private static void printTasks() {
        try {
            transaction.begin();

            TypedQuery<Todolist> allTaskQuery = entityManager.createNamedQuery("listTasks", Todolist.class);

            for (Todolist tasks : allTaskQuery.getResultList()){
                System.out.println(tasks);
            }

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    }


    private static void removeItemMenu(Scanner input) {
        Long index;

        System.out.println("Please select item to remove by id");
        printTasks();
        index = input.nextLong();
        try {
            transaction.begin();
            Query removeById = entityManager.createQuery("delete from Todolist where id=?1");
            removeById.setParameter(1,index);
            removeById.executeUpdate();

            transaction.commit();

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
        }

        menu();
    }

    public static void addItemMenu(Scanner input) {
        String task;
        System.out.println("Please enter task");
        input.nextLine();
        task = input.nextLine();
        try {
            transaction.begin();
          taskList.setTask(task);
            entityManager.persist(taskList);
            transaction.commit();

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
        menu();
    }
}
