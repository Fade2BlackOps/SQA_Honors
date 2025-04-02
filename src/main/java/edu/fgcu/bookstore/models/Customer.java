package edu.fgcu.bookstore.models;

public class Customer  extends Person {

    // Constructors
    // ----------
    public Customer() {} // empty constructor

    public Customer(String name, String phoneNumber, String email, String address) {
        super(name, phoneNumber, email, address); // construct Person
    }

    // Methods
    // -------------

    /**
     * Simulates buying a book.
     */
    public void buyBook(Book book) {
        System.out.println(getName() + " has bought a book.");
    }

    /**
     * Simulates returning a book.
     */
    public void returnBook() {
        System.out.println(getName() + " has returned a book.");
    }

}
