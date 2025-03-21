package classes;

public class Author extends Person {

    // Constructors
    // -------
    public Author() {}

    public Author(String name, String phoneNumber, String email, String address) {
        super(name, phoneNumber, email, address);
    }

    // Methods
    // --------

    /**
     * Simulates an Author writing a Book
     *
     * @return book = the new book that was written
     */
    public Book writeBook() {
        System.out.println("Author" + getName() + "is writing a book.");
        Book book = new Book();
        // TODO: Fill in the rest of the logic for a book being written.
        return book;
    }

    /**
     * Simulates an Author revising a Book
     */
    public void reviseBook(Book book) {
        System.out.println("Author" + getName() + "is revising a book.");
        // book.openBook(edit mode)
        // Book should open in author's default word-processing app
    }

}
