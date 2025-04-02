package edu.fgcu.bookstore.models;

import enums.GENRE;
import enums.BOOK_TYPE;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Book {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String title;
    private String isbn;
    private Author author = Author.NONE; // Default to NONE if no author is provided
    // This ensures that the book always has a valid author reference
    private Publisher publisher = Publisher.NONE; // Default to NONE if no publisher is provided
    // This ensures that the book always has a valid publisher reference
    private int pageCount;
    private float price;
    private GENRE genre;
    private BOOK_TYPE bookType = BOOK_TYPE.None; // Type of book (e.g., physical, digital)
    protected String filePath = ""; // Path to the book file (e.g., .pdf, .epub, etc.)

    // Constructors
    // ----------------------
    public Book() {}

    
    public Book(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String filePath) {
        this.title = title;
        this.isbn = isbn;
        this.author = author != null ? author : Author.NONE; // Ensure author is not null
        // Default to NONE if no author is provided
        this.publisher = publisher != null ? publisher : Publisher.NONE; // Ensure publisher is not null
        // Default to NONE if no publisher is provided
        this.pageCount = pageCount;
        this.price = price;
        this.genre = genre;
        this.bookType = BOOK_TYPE.DIGITAL;
        this.filePath = filePath;
    }

    // Constructor for physical books (no file path)
    public Book(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.price = price;
        this.genre = genre;
        this.bookType = BOOK_TYPE.PHYSICAL;
    }


    // Getters and Setters
    // --------
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    public Author getAuthor() {return author;}
    public void setAuthor(Author author) {this.author = author;}

    public Publisher getPublisher() {return publisher;}
    public void setPublisher(Publisher publisher) {this.publisher = publisher;}

    public int getPageCount() {return pageCount;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}

    public GENRE getGenre() {return genre;}
    public void setGenre(GENRE genre) {this.genre = genre;}

    public BOOK_TYPE getBookType() {return bookType;}
    public void setBookType(BOOK_TYPE bookType) {this.bookType = bookType;}

    public String getFilePath() {return filePath;}
    public void setFilePath(String filePath) {this.filePath = filePath;}


    // Methods
    // --------------    

    /**
     * Simulates a Book being read.
     * This method can be called by a Person to read the book.
     */
    public void openBook(String filePath) {
        System.out.println("Opening book: " + title + " by " + author);

        if (bookType == BOOK_TYPE.PHYSICAL) {
            System.out.println("This is a physical book. Please read it in hand.");
            return;
        }

        if (filePath == null || filePath.isEmpty()) {
            System.out.println("ERROR: File path is not set for this book.");
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("ERROR: File does not exist: " + filePath);
            return;
        }

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException e) {
                System.out.println("An error occurred while trying to open the file: " + e.getMessage());
            }
        } else {
            System.out.println("Desktop operations are not supported on this system.");
        }
    }

    
}




