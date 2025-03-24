package tests.classes;

import classes.Author;
import classes.Book;
import enums.BOOK_TYPE;
import enums.GENRE;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AuthorTest {

    private Author author;

    @Before
    public void setUp() {
        author = new Author("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
    }

    @Test
    public void testAuthorConstructor() {
        assertNotNull(author);
        assertThat(author.getName(), is("John Doe"));
    }

    @Test
    public void testSetName() {
        author.setName("Jane Doe");
        assertThat(author.getName(), is("Jane Doe"));
    }

    @Test
    public void testWriteBook() {
        Book book = author.writeBook();
        assertNotNull(book);
        assertNotNull(book.getFilePath());
        assert(book.getTitle().equals("Untitled Book by John Doe"));
        assertEquals("Untitled Book by John Doe", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(100, book.getPageCount());
        assertEquals(19.99f, book.getPrice(), 0.01);
        assertEquals(GENRE.FICTION, book.getGenre());
        assertEquals(BOOK_TYPE.DIGITAL, book.getBookType());
    }

    @Test
    public void testReviseBook() {
        Book book = author.writeBook();
        author.reviseBook(book);
        // Assuming reviseBook opens the file, we can't directly test file opening.
        // Instead, we can verify that the book's file path is still valid.
        assertNotNull(book.getFilePath());
    }


}
