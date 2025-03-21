package classes;

public class Publisher extends Person {

    // Constructors
    // -------
    public Publisher() {}

    public Publisher(String name, String phoneNumber, String email, String address) {
        super(name, phoneNumber, email, address);
    }

    // Methods
    // ------------

    /**
     * Simulates a Publisher editing a book
     * Publishers can suggest edits to a book
     */
    public void editBook(Book book) {
        System.out.println("Publisher " + getName() + " is editing a book.");
        // book.openBook("edit"); // Open the book in edit mode
    }

    /**
     * Simulates a Publisher publishing a book
     * Publishers can publish a book
     */
    public void publishBook(Book book) {
        System.out.println("Publisher " + getName() + " is publishing a book.");
        // List book for sale in database
        // book.publish(); // Publish the book
    }

    /**
     * Publisher can set the wholesale price of a book
     * @param book the book to set the price for
     * @param price the wholesale price to set
     */
    public void setWholesalePrice(Book book, float price) {
        System.out.println("Publisher " + getName() + " is setting the wholesale price of the book to $" + price);
        book.setPrice(price); // Set the wholesale price of the book
    }

}
