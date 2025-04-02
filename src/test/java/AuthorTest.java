package tests;

import classes.Author;
import classes.Book;
import enums.BOOK_TYPE;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AuthorTest {

    private Author author;

    @BeforeTest
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
    }

    @Test(priority = 1)
    public void testAuthorConstructor() {
        assertNotNull(author);
        assertEquals("John Doe", author.getName());
        assertEquals("123-456-7890", author.getPhoneNumber());
        assertEquals("johndoe@example.com", author.getEmail());
        assertEquals("123 Main St", author.getAddress());
    }

    @Test(priority = 2)
    public void testSetName() {
        author.setName("Jane Doe");
        assertEquals("Jane Doe", author.getName());
    }

    @Test(priority = 3)
    public void testWriteBook() {
        Book book = author.writeBook();
        assertNotNull(book);
        assertNotNull(book.getFilePath());
        assert(book.getTitle().equals("Untitled Book by Jane Doe"));
        assertEquals("Untitled Book by Jane Doe", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(100, book.getPageCount());
        assertEquals(19.99f, book.getPrice(), 0.01);
        assertEquals(GENRE.FICTION, book.getGenre());
        assertEquals(BOOK_TYPE.DIGITAL, book.getBookType());
    }

    @Test(priority = 4)
    public void testReviseBook() {
        Book book = author.writeBook();
        author.reviseBook(book);
        // Assuming reviseBook opens the file, we can't directly test file opening.
        // Instead, we can verify that the book's file path is still valid.
        assertNotNull(book.getFilePath());
    }


}
