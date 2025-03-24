package classes;

import enums.GENRE;

public class EBook extends Book {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String fileFormat; // e.g., PDF, EPUB, MOBI
    private float fileSize; // in MB

    // Constructors
    // ----------------------
    public EBook() {}

    public EBook(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String filePath, String fileFormat, float fileSize) {
        super(title, isbn, author, publisher, pageCount, price, genre, filePath);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    // Getters and Setters
    // --------
    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }

    public float getFileSize() { return fileSize; }
    public void setFileSize(float fileSize) { this.fileSize = fileSize; }
    
}