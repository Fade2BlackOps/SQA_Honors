import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class BookTest {

    private Book book;
    private Author author;
    private Publisher publisher;

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        publisher = new Publisher("Test Publisher", "456-789-1234", "publisher@example.com", "456 Publisher St");
        book = new Book("Test Title", "1234567890", author, publisher, 200, 29.99f, GENRE.FICTION, "test/path/to/book.docx");
    }

    @Test(priority = 1)
    public void testBookConstructor() {
        assertNotNull(book, "Book instance should not be null after construction.");
        assertEquals(book.getTitle(), "Test Title");
        assertEquals(book.getIsbn(), "1234567890");
        assertEquals(book.getAuthor(), author);
        assertEquals(book.getPublisher(), publisher);
        assertEquals(book.getPageCount(), 200);
        assertEquals(book.getPrice(), 29.99f, 0.01);
        assertEquals(book.getGenre(), GENRE.FICTION);
        assertEquals(book.getBookType(), BOOK_TYPE.DIGITAL);
        assertEquals(book.getFilePath(), "test/path/to/book.docx");
    }

    @Test(priority = 2)
    public void testSetTitle() {
        book.setTitle("New Title");
        assertEquals(book.getTitle(), "New Title");
    }

    @Test(priority = 3)
    public void testSetIsbn() {
        book.setIsbn("0987654321");
        assertEquals(book.getIsbn(), "0987654321");
    }

    @Test(priority = 4)
    public void testSetAuthor() {
        Author newAuthor = new Author("Jane Doe", "987-654-3210", "janedoe@example.com", "789 Main St");
        book.setAuthor(newAuthor);
        assertEquals(book.getAuthor(), newAuthor);
    }

    @Test(priority = 5)
    public void testSetPublisher() {
        Publisher newPublisher = new Publisher("New Publisher", "111-222-3333", "newpublisher@example.com", "123 New St");
        book.setPublisher(newPublisher);
        assertEquals(book.getPublisher(), newPublisher);
    }

    @Test(priority = 6)
    public void testSetPageCount() {
        book.setPageCount(300);
        assertEquals(book.getPageCount(), 300);
    }

    @Test(priority = 7)
    public void testSetPrice() {
        book.setPrice(19.99f);
        assertEquals(book.getPrice(), 19.99f, 0.01);
    }

    @Test(priority = 8)
    public void testSetGenre() {
        book.setGenre(GENRE.NON_FICTION);
        assertEquals(book.getGenre(), GENRE.NON_FICTION);
    }

    @Test(priority = 9)
    public void testSetBookType() {
        book.setBookType(BOOK_TYPE.PHYSICAL);
        assertEquals(book.getBookType(), BOOK_TYPE.PHYSICAL);
    }

    @Test(priority = 10)
    public void testSetFilePath() {
        book.setFilePath("new/path/to/book.docx");
        assertEquals(book.getFilePath(), "new/path/to/book.docx");
    }

    @Test(priority = 11)
    public void testOpenBookWithValidFilePath() {
        book.setBookType(BOOK_TYPE.DIGITAL);
        book.setFilePath("test/path/to/book.docx");
        // Simulate opening the book (this will print messages to the console)
        book.openBook(book.getFilePath());
        assertEquals(book.getFilePath(), "test/path/to/book.docx");
    }

    @Test(priority = 12)
    public void testOpenBookWithInvalidFilePath() {
        book.setBookType(BOOK_TYPE.DIGITAL);
        book.setFilePath("invalid/path/to/book.docx");
        // Simulate opening the book with an invalid path (this will print error messages to the console)
        book.openBook(book.getFilePath());
        assertEquals(book.getFilePath(), "invalid/path/to/book.docx");
    }

    @Test(priority = 13)
    public void testOpenPhysicalBook() {
        book.setBookType(BOOK_TYPE.PHYSICAL);
        book.openBook(book.getFilePath());
        assertEquals(book.getBookType(), BOOK_TYPE.PHYSICAL);
    }

}
