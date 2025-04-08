import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class HardcoverTest {

    private Hardcover hardcover;
    private Author author;
    private Publisher publisher;

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        publisher = new Publisher("Test Publisher", "456-789-1234", "publisher@example.com", "456 Publisher St");
        hardcover = new Hardcover(
            "Hardcover Title",
            "1234567890",
            author,
            publisher,
            300,
            29.99f,
            GENRE.FICTION,
            "Hardcover",
            500.0f
        );
    }

    @Test(priority = 1)
    public void testHardcoverConstructor() {
        assertNotNull(hardcover, "Hardcover instance should not be null after construction.");
        assertEquals(hardcover.getTitle(), "Hardcover Title", "Title should be initialized correctly.");
        assertEquals(hardcover.getIsbn(), "1234567890", "ISBN should be initialized correctly.");
        assertEquals(hardcover.getAuthor(), author, "Author should be initialized correctly.");
        assertEquals(hardcover.getPublisher(), publisher, "Publisher should be initialized correctly.");
        assertEquals(hardcover.getPageCount(), 300, "Page count should be initialized correctly.");
        assertEquals(hardcover.getPrice(), 29.99f, 0.01, "Price should be initialized correctly.");
        assertEquals(hardcover.getGenre(), GENRE.FICTION, "Genre should be initialized correctly.");
        assertEquals(hardcover.getCoverType(), "Hardcover", "Cover type should be initialized correctly.");
        assertEquals(hardcover.getWeight(), 500.0f, 0.01, "Weight should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetCoverType() {
        hardcover.setCoverType("Softcover");
        assertEquals(hardcover.getCoverType(), "Softcover", "Cover type should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetWeight() {
        hardcover.setWeight(600.0f);
        assertEquals(hardcover.getWeight(), 600.0f, 0.01, "Weight should be updated correctly.");
    }
}
