package classes;

import java.util.HashMap;
import java.util.Map;

public class Store {
    
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String name;
    private String address;
    private String phoneNumber;
    private String businessLicense;
    private Map<Book, Integer> inventory; // Maps book ISBN to quantity in stock

    // Constructors
    // ----------------------
    public Store() {}

    public Store(String name, String address, String phoneNumber, String businessLicense) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.businessLicense = ""; // Default to empty if not provided
        this.inventory = new HashMap<>(); // Initialize inventory
    }

    
    // Getters and Setters
    // --------
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getBusinessLicense() { return businessLicense; }
    public void setBusinessLicense(String businessLicense) { this.businessLicense = businessLicense; }

    public Map<Book, Integer> getInventory() { return inventory; }
    public void setInventory(HashMap<Book, Integer> inventory) { this.inventory = inventory; }

    
    // Methods
    // --------------

    /**
     * Adds a book to the store's inventory.
     * @param isbn The ISBN of the book.
     * @param quantity The quantity of the book to add.
     */
    public void addBookToStock(Book book, int quantity) {
        if (quantity > 0) {
            inventory.put(book, inventory.getOrDefault(book, 0) + quantity);
            System.out.println("Added " + quantity + " copies of book with ISBN " + book.getIsbn() + " to stock.");
        } else {
            System.out.println("Quantity must be greater than zero.");
        }
    }

    /**
     * Removes a book from the store's inventory.
     * @param isbn The ISBN of the book.
     * @param quantity The quantity of the book to remove.
     */
    public void removeBookFromStock(Book book, int quantity) {
        if (inventory.containsKey(book)) {
            int currentQuantity = inventory.get(book);
            if (quantity > 0 && currentQuantity >= quantity) {
                inventory.put(book, currentQuantity - quantity);
                System.out.println("Removed " + quantity + " copies of book with ISBN " + book.getIsbn() + " from stock.");
            } else {
                System.out.println("Not enough stock to remove " + quantity + " copies of book with ISBN " + book.getIsbn() + ".");
            }
        } else {
            System.out.println("Book with ISBN " + book.getIsbn() + " not found in inventory.");
        }
    }

    /**
     * Checks the stock of a book by its ISBN.
     * @param isbn The ISBN of the book.
     * @return The quantity of the book in stock, or 0 if not found.
     */
    public int checkBookStock(Book book) {
        return inventory.getOrDefault(book, 0);
    }

    /**
     * Displays the store's inventory.
     */
    public void displayInventory() {
        System.out.println("Store Inventory:");
        for (Book book : inventory.keySet()) {
            System.out.println("ISBN: " + book.getIsbn() + ", Quantity: " + inventory.get(book));
        }
    }

    /**
     * Simulates a store ordering physical books to stock.
     */
    public void orderBooks(Paperback book, int quantity) {
        System.out.println("Ordering " + quantity + " copies of book with ISBN " + book.getIsbn() + " for the store.");
        addBookToStock(book, quantity);
    }

}
