// ToDoListManager.java
package main.java.com.tsaperlein.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListManager {
    private List<String> toDoList;

    public ToDoListManager() {
        this.toDoList = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select an option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.println("Exiting ToDo List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        
        scanner.close();
    }

    private void addTask(String task) {
        toDoList.add(task);
        System.out.println("Task added successfully!");
    }

    private void viewTasks() {
        System.out.println("ToDo List:");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i + 1) + ". " + toDoList.get(i));
        }
    }
}
