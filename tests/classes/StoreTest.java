package tests.classes;

import classes.Store;
import classes.Book;
import classes.Paperback;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class StoreTest {

    private Store store;
    private Book book1;
    private Book book2;

    @BeforeTest
    public void setUp() {
        store = new Store("Test Bookstore", "123 Main St", "123-456-7890", "BL12345");
        book1 = new Book("Book One", "1111", null, null, 100, 10.99f, GENRE.FICTION, "path/to/book1.docx");
        book2 = new Paperback("Book Two", "2222", null, null, 200, 15.99f, GENRE.NON_FICTION, "Softcover", 300.0f);
    }

    @Test(priority = 1)
    public void testStoreConstructor() {
        assertNotNull(store, "Store instance should not be null after construction.");
        assertEquals(store.getName(), "Test Bookstore", "Store name should be initialized correctly.");
        assertEquals(store.getAddress(), "123 Main St", "Store address should be initialized correctly.");
        assertEquals(store.getPhoneNumber(), "123-456-7890", "Store phone number should be initialized correctly.");
        assertEquals(store.getBusinessLicense(), "BL12345", "Store business license should be initialized correctly.");
        assertTrue(store.getInventory().isEmpty(), "Store inventory should be empty upon initialization.");
    }

    @Test(priority = 2)
    public void testAddBookToStock() {
        store.addBookToStock(book1, 10);
        assertEquals(store.checkBookStock(book1), 10, "Book stock should be updated correctly after adding books.");
    }

    @Test(priority = 3)
    public void testRemoveBookFromStock() {
        store.addBookToStock(book1, 10);
        store.removeBookFromStock(book1, 5);
        assertEquals(store.checkBookStock(book1), 5, "Book stock should be updated correctly after removing books.");
    }

    @Test(priority = 4)
    public void testRemoveBookFromStockInsufficientQuantity() {
        store.addBookToStock(book1, 5);
        store.removeBookFromStock(book1, 10);
        assertEquals(store.checkBookStock(book1), 5, "Book stock should remain unchanged if insufficient quantity is available.");
    }

    @Test(priority = 5)
    public void testCheckBookStock() {
        store.addBookToStock(book1, 10);
        assertEquals(store.checkBookStock(book1), 10, "Book stock should be returned correctly.");
        assertEquals(store.checkBookStock(book2), 0, "Book stock should return 0 for books not in inventory.");
    }

    @Test(priority = 6)
    public void testDisplayInventory() {
        store.addBookToStock(book1, 10);
        store.addBookToStock(book2, 5);
        store.displayInventory();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }

    @Test(priority = 7)
    public void testOrderBooks() {
        Paperback paperback = (Paperback) book2;
        store.orderBooks(paperback, 20);
        assertEquals(store.checkBookStock(book2), 20, "Book stock should be updated correctly after ordering books.");
    }
}
