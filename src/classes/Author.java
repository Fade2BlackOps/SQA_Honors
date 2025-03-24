package classes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import enums.BOOK_TYPE;
import enums.GENRE;

public class Author extends Person {
    private String name;

    public static final Author NONE = new Author("None");

    // Constructors
    // -------
    public Author() {}

    public Author(String name, String phoneNumber, String email, String address) {
        super(name, phoneNumber, email, address);
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        try {
            // Create a new book file
            String bookFileName = getName().replaceAll("\\s+", "_") + "_Book.txt";
            File bookFile = new File(bookFileName);
            if (bookFile.createNewFile()) {
                System.out.println("Book file created: " + bookFile.getAbsolutePath());
            } else {
                System.out.println("Book file already exists: " + bookFile.getAbsolutePath());
            }

            // Open the file in the default word processor
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(bookFile);
            } else {
                System.out.println("Desktop operations are not supported on this system.");
            }

            // Set the file path in the Book object
            book.setFilePath(bookFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while creating or opening the book file: " + e.getMessage());
        }

        // Set other book properties (title, author, etc.)
        book.setTitle("Untitled Book by " + getName());
        book.setAuthor(this);
        book.setPageCount(100); // Default page count
        book.setPrice(19.99f); // Default price
        book.setGenre(GENRE.FICTION); // Default genre
        book.setBookType(BOOK_TYPE.DIGITAL); // Default book type
        book.setFilePath(getAddress() + "/" + book.getTitle().replaceAll("\\s+", "_") + ".txt"); // Set file path
        
        
        return book;
    }

    /**
     * Simulates an Author revising a Book
     */
    public void reviseBook(Book book) {
        System.out.println("Author" + getName() + "is revising a book.");
        book.openBook(book.getFilePath());
        // Book should open in author's default word-processing app
    }

}
