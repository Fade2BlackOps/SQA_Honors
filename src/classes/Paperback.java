package classes;

import enums.GENRE;

public class Paperback extends Book {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String coverType; // e.g., Softcover, Hardcover
    private float weight; // in grams

    // Constructors
    // ----------------------
    public Paperback() {}

    public Paperback(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String coverType, float weight) {
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
    
}