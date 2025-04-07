package edu.fgcu.bookstore.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Cash;
import classes.CreditCard;
import classes.DebitCard;
import classes.GiftCard;
import classes.Payment;

public class Main {
    private static Map<String, Integer> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Database connection setup (example using SQLite)
        String url_database = "jdbc:sqlite:src/main/sql/bookstore.db";
        try (Connection conn = DriverManager.getConnection(url_database)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS books " +
                             "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                             " title TEXT NOT NULL, " +
                             " quantity INTEGER NOT NULL)";
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            System.out.println("\n=== Bookstore System ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Add a Book");
            System.out.println("3. Remove a Book");
            System.out.println("4. Process Payment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    processPayment();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewInventory() {
        System.out.println("\n=== Inventory ===");
        if (inventory.isEmpty()) {
            System.out.println("No books in inventory.");
        } else {
            inventory.forEach((book, quantity) -> System.out.println(book + " - " + quantity + " copies"));
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        inventory.put(title, inventory.getOrDefault(title, 0) + quantity);
        System.out.println(quantity + " copies of '" + title + "' added to inventory.");
    }

    private static void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        if (inventory.containsKey(title)) {
            inventory.remove(title);
            System.out.println("'" + title + "' removed from inventory.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void processPayment() {
        System.out.print("Enter amount to pay: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose payment method: ");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        System.out.println("4. Gift Card");
        System.out.print("Enter choice: ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Payment payment;
        switch (paymentChoice) {
            case 1:
                payment = new Cash(amount);
                break;
            case 2:
                System.out.print("Enter cardholder name: ");
                String creditName = scanner.nextLine();
                System.out.print("Enter card number: ");
                int creditNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter processing network: ");
                String network = scanner.nextLine();
                System.out.print("Enter security code: ");
                int securityCode = scanner.nextInt();
                payment = new CreditCard(amount, creditName, String.valueOf(creditNumber), network, securityCode);
                break;
            case 3:
                System.out.print("Enter cardholder name: ");
                String debitName = scanner.nextLine();
                System.out.print("Enter card number: ");
                int debitNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter bank name: ");
                String bank = scanner.nextLine();
                payment = new DebitCard(amount, debitName, String.valueOf(debitNumber), bank);
                break;
            case 4:
                System.out.print("Enter cardholder name: ");
                String giftName = scanner.nextLine();
                System.out.print("Enter card number: ");
                int giftNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter gift card balance: ");
                float balance = scanner.nextFloat();
                payment = new GiftCard(amount, giftName, String.valueOf(giftNumber), balance);
                break;
            default:
                System.out.println("Invalid payment choice.");
                return;
        }
        
        payment.processPayment(paymentChoice, null, paymentChoice);
    }
}
