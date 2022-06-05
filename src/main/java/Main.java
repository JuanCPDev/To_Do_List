import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    static TaskList tasks = new TaskList();
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

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
                System.out.println("Goodbye");
                return;

            default:
                System.out.println("Invalid entry\n");
                menu();
                break;
        }
    }

    private static void printTasks() {

        if (tasks.listSize() < 1) {
            System.out.println("Your to-do list is empty.\n");
        } else {
            tasks.printList();
        }
    }


    private static void removeItemMenu(Scanner input) {
        int index;

        System.out.println("Please select item to remove");
        tasks.printList();
        index = input.nextInt();

        if (index > tasks.listSize()) {
            System.out.println("Invalid selection, try again");
            removeItemMenu(input);
        } else {
            tasks.removeTask(index);
        }
        menu();
    }

    public static void addItemMenu(Scanner input) {
        String task;
        System.out.println("Please enter task");
        input.nextLine();
        task = input.nextLine();
        tasks.addTask(task);
        menu();
    }
}
