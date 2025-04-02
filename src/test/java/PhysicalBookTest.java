package tests;

import classes.PhysicalBook;
import classes.Author;
import classes.Publisher;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PhysicalBookTest {

    private PhysicalBook physicalBook;
    private Author author;
    private Publisher publisher;

    // Mock subclass of Physical_Book for testing purposes
    private static class MockPhysicalBook extends PhysicalBook {
        public MockPhysicalBook(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String coverType, float weight) {
            super(title, isbn, author, publisher, pageCount, price, genre, coverType, weight);
        }
    }

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        publisher = new Publisher("Test Publisher", "456-789-1234", "publisher@example.com", "456 Publisher St");
        physicalBook = new MockPhysicalBook(
            "Physical Book Title",
            "1234567890",
            author,
            publisher,
            300,
            24.99f,
            GENRE.FICTION,
            "Hardcover",
            500.0f
        );
    }

    @Test(priority = 1)
    public void testPhysicalBookConstructor() {
        assertNotNull(physicalBook, "Physical_Book instance should not be null after construction.");
        assertEquals(physicalBook.getTitle(), "Physical Book Title", "Title should be initialized correctly.");
        assertEquals(physicalBook.getIsbn(), "1234567890", "ISBN should be initialized correctly.");
        assertEquals(physicalBook.getAuthor(), author, "Author should be initialized correctly.");
        assertEquals(physicalBook.getPublisher(), publisher, "Publisher should be initialized correctly.");
        assertEquals(physicalBook.getPageCount(), 300, "Page count should be initialized correctly.");
        assertEquals(physicalBook.getPrice(), 24.99f, 0.01, "Price should be initialized correctly.");
        assertEquals(physicalBook.getGenre(), GENRE.FICTION, "Genre should be initialized correctly.");
        assertEquals(physicalBook.getCoverType(), "Hardcover", "Cover type should be initialized correctly.");
        assertEquals(physicalBook.getWeight(), 500.0f, 0.01, "Weight should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetCoverType() {
        physicalBook.setCoverType("Softcover");
        assertEquals(physicalBook.getCoverType(), "Softcover", "Cover type should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetWeight() {
        physicalBook.setWeight(600.0f);
        assertEquals(physicalBook.getWeight(), 600.0f, 0.01, "Weight should be updated correctly.");
    }
}
