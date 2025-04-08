import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PaperbackTest {

    private Paperback paperback;
    private Author author;
    private Publisher publisher;

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        publisher = new Publisher("Test Publisher", "456-789-1234", "publisher@example.com", "456 Publisher St");
        paperback = new Paperback(
            "Paperback Title",
            "1234567890",
            author,
            publisher,
            250,
            19.99f,
            GENRE.NON_FICTION,
            "Softcover",
            300.0f
        );
    }

    @Test(priority = 1)
    public void testPaperbackConstructor() {
        assertNotNull(paperback, "Paperback instance should not be null after construction.");
        assertEquals(paperback.getTitle(), "Paperback Title", "Title should be initialized correctly.");
        assertEquals(paperback.getIsbn(), "1234567890", "ISBN should be initialized correctly.");
        assertEquals(paperback.getAuthor(), author, "Author should be initialized correctly.");
        assertEquals(paperback.getPublisher(), publisher, "Publisher should be initialized correctly.");
        assertEquals(paperback.getPageCount(), 250, "Page count should be initialized correctly.");
        assertEquals(paperback.getPrice(), 19.99f, 0.01, "Price should be initialized correctly.");
        assertEquals(paperback.getGenre(), GENRE.NON_FICTION, "Genre should be initialized correctly.");
        assertEquals(paperback.getCoverType(), "Softcover", "Cover type should be initialized correctly.");
        assertEquals(paperback.getWeight(), 300.0f, 0.01, "Weight should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetCoverType() {
        paperback.setCoverType("Hardcover");
        assertEquals(paperback.getCoverType(), "Hardcover", "Cover type should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetWeight() {
        paperback.setWeight(350.0f);
        assertEquals(paperback.getWeight(), 350.0f, 0.01, "Weight should be updated correctly.");
    }
}
