package tests.classes;

import classes.EBook;
import classes.Author;
import classes.Publisher;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class EBookTest {

    private EBook eBook;
    private Author author;
    private Publisher publisher;

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        publisher = new Publisher("Test Publisher", "456-789-1234", "publisher@example.com", "456 Publisher St");
        eBook = new EBook(
            "EBook Title",
            "1234567890",
            author,
            publisher,
            150,
            9.99f,
            GENRE.FICTION,
            "path/to/ebook.docx",
            "PDF",
            2.5f
        );
    }

    @Test(priority = 1)
    public void testEBookConstructor() {
        assertNotNull(eBook, "EBook instance should not be null after construction.");
        assertEquals(eBook.getTitle(), "EBook Title", "Title should be initialized correctly.");
        assertEquals(eBook.getIsbn(), "1234567890", "ISBN should be initialized correctly.");
        assertEquals(eBook.getAuthor(), author, "Author should be initialized correctly.");
        assertEquals(eBook.getPublisher(), publisher, "Publisher should be initialized correctly.");
        assertEquals(eBook.getPageCount(), 150, "Page count should be initialized correctly.");
        assertEquals(eBook.getPrice(), 9.99f, 0.01, "Price should be initialized correctly.");
        assertEquals(eBook.getGenre(), GENRE.FICTION, "Genre should be initialized correctly.");
        assertEquals(eBook.getFilePath(), "path/to/ebook.docx", "File path should be initialized correctly.");
        assertEquals(eBook.getFileFormat(), "PDF", "File format should be initialized correctly.");
        assertEquals(eBook.getFileSize(), 2.5f, 0.01, "File size should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetFileFormat() {
        eBook.setFileFormat("EPUB");
        assertEquals(eBook.getFileFormat(), "EPUB", "File format should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetFileSize() {
        eBook.setFileSize(3.0f);
        assertEquals(eBook.getFileSize(), 3.0f, 0.01, "File size should be updated correctly.");
    }

    @Test(priority = 4)
    public void testSetFilePath() {
        eBook.setFilePath("new/path/to/ebook.docx");
        assertEquals(eBook.getFilePath(), "new/path/to/ebook.docx", "File path should be updated correctly.");
    }
}
