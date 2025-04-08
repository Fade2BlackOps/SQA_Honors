import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PublisherTest {

    private Publisher publisher;
    private Book book;

    @BeforeTest
    public void setUp() {
        publisher = new Publisher("Test Publisher", "123-456-7890", "publisher@example.com", "123 Publisher St");
        book = new Book("Test Book", "1234567890", null, publisher, 200, 19.99f, GENRE.FICTION, "path/to/book.docx");
    }

    @Test(priority = 1)
    public void testPublisherConstructor() {
        assertNotNull(publisher, "Publisher instance should not be null after construction.");
        assertEquals(publisher.getName(), "Test Publisher", "Publisher name should be initialized correctly.");
        assertEquals(publisher.getPhoneNumber(), "123-456-7890", "Publisher phone number should be initialized correctly.");
        assertEquals(publisher.getEmail(), "publisher@example.com", "Publisher email should be initialized correctly.");
        assertEquals(publisher.getAddress(), "123 Publisher St", "Publisher address should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetName() {
        publisher.setName("New Publisher Name");
        assertEquals(publisher.getName(), "New Publisher Name", "Publisher name should be updated correctly.");
    }

    @Test(priority = 3)
    public void testEditBook() {
        publisher.editBook(book);
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }

    @Test(priority = 4)
    public void testPublishBook() {
        publisher.publishBook(book);
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }

    @Test(priority = 5)
    public void testSetWholesalePrice() {
        publisher.setWholesalePrice(book, 15.99f);
        assertEquals(book.getPrice(), 15.99f, 0.01, "Book price should be updated correctly by the publisher.");
    }
}
