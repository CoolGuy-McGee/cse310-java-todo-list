package edu.byu.cse310.todoj;

import java.io.IOException;
import java.util.Scanner;

/**
 * Simple CLI entry point demonstrating conditionals, loops, classes, and collections.
 */
public class Main {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();
        String filename = "todos.txt";
        try {
            manager.loadFromFile(filename);
        } catch (IOException e) {
            // ignore if file does not exist or cannot be read
        }

        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("--- To-Do Menu ---");
            System.out.println("1) Add todo");
            System.out.println("2) List todos");
            System.out.println("3) Toggle status (by number)");
            System.out.println("4) Save and quit");
            System.out.print("Choice: ");
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Title: ");
                    String title = in.nextLine().trim();
                    System.out.print("Priority (1-5): ");
                    String pstr = in.nextLine().trim();
                    int p = 1;
                    try {
                        p = Integer.parseInt(pstr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number, using priority=1");
                    }
                    manager.addTodo(title, p);
                    System.out.println("Added.");
                    break;
                case "2":
                    manager.listTodos();
                    break;
                case "3":
                    manager.listTodos();
                    System.out.print("Number to toggle: ");
                    String numStr = in.nextLine().trim();
                    try {
                        int n = Integer.parseInt(numStr);
                        boolean ok = manager.toggleStatusByIndex(n - 1);
                        System.out.println(ok ? "Toggled." : "Not found.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "4":
                    try {
                        manager.saveToFile(filename);
                        System.out.println("Saved to " + filename);
                    } catch (IOException e) {
                        System.out.println("Failed to save: " + e.getMessage());
                    }
                    running = false;
                    break;
                default:
                    System.out.println("Unknown choice.");
            }
        }
        in.close();
    }
}
