package classes;

import enums.GENRE;

public abstract class PhysicalBook extends Book {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String coverType; // e.g., Softcover, Hardcover
    private float weight; // in grams

    // Constructors
    // ----------------------
    public PhysicalBook() {}

    public PhysicalBook(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String coverType, float weight) {
        super(title, isbn, author, publisher, pageCount, price, genre);
        this.coverType = coverType;
        this.weight = weight;
    }

    // Getters and Setters
    // --------
    public String getCoverType() { return coverType; }
    public void setCoverType(String coverType) { this.coverType = coverType; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }


} // Note: This class is abstract and should be extended by specific types of physical books (e.g., Paperback, Hardcover).
  // This allows for the addition of specific attributes or methods relevant to those types of books.