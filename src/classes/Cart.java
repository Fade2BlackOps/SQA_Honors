package classes;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private Customer customer; // Customer associated with the cart
    private Map<Book, Integer> items; // Maps book to quantity in cart
    private float totalPrice = 0.00f; // Total price of items in the cart

    // Constructors
    // ----------------------
    public Cart() {
        this.items = new HashMap<>();
    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new HashMap<>();
    }

    // Getters and Setters
    // --------
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Map<Book, Integer> getItems() { return items; }
    
    // Methods
    // --------------
    
    /**
     * Adds a book to the cart.
     * @param book The book to add.
     * @param quantity The quantity of the book to add.
     */
    public void addBookToCart(Book book, int quantity) {
        if (quantity > 0) {
            items.put(book, items.getOrDefault(book, 0) + quantity);
            System.out.println("Added " + quantity + " copies of book with ISBN " + book.getIsbn() + " to cart.");
        } else {
            System.out.println("Quantity must be greater than zero.");
        }
    }

    /**
     * Removes a book from the cart.
     * @param book The book to remove.
     */
    public void removeBookFromCart(Book book) {
        if (items.containsKey(book)) {
            items.remove(book);
            System.out.println("Removed book with ISBN " + book.getIsbn() + " from cart.");
        } else {
            System.out.println("Book with ISBN " + book.getIsbn() + " not found in cart.");
        }
    }

    /**
     * Calculates the total price of items in the cart.
     * @return The total price.
     */
    public float calculateTotalPrice() {
        totalPrice = 0.00f;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += book.getPrice() * quantity; // Assuming Book has a getPrice() method
        }
        return totalPrice;
    }

    /**
     * Displays the contents of the cart.
     */
    public void displayCartContents() {
        System.out.println("Cart Contents:");
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Quantity: " + quantity);
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    /**
     * Clears the cart.
     */
    public void clearCart() {
        items.clear();
        totalPrice = 0.00f;
        System.out.println("Cart has been cleared.");
    }
    
}
