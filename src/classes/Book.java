package classes;

import enums.GENRE;

public class Book {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String title;
    private String isbn;
    // TODO: Change author and publisher to reference their classes.
    private String author;
    private String publisher;
    private int pageCount;
    private float price;
    private GENRE genre;

    // Constructors
    // ----------------------
    public Book() {}

    public Book(String title, String isbn, String author, String publisher, int pageCount, float price, GENRE genre) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.price = price;
        this.genre = genre;
    }

    // Getters and Setters
    // --------
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}

    public int getPageCount() {return pageCount;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}

    public GENRE getGenre() {return genre;}
    public void setGenre(GENRE genre) {this.genre = genre;}


    // Methods
    // --------------

    // Actually, Book doesn't have any methods yet, so...
    // TODO: Determine if Book class needs any methods.
    // TODO: Add openBook method which opens a book's file path

}




