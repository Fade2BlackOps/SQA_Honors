package tests.classes;

import classes.Customer;
import classes.Book;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CustomerTest {

    private Customer customer;
    private Book book;

    @BeforeTest
    public void setUp() {
        customer = new Customer("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        book = new Book("Test Book", "1234567890", null, null, 100, 19.99f, GENRE.FICTION, "path/to/book.docx");
    }

    @Test(priority = 1)
    public void testCustomerConstructor() {
        assertNotNull(customer, "Customer instance should not be null after construction.");
        assertEquals(customer.getName(), "John Doe", "Customer name should be initialized correctly.");
        assertEquals(customer.getPhoneNumber(), "123-456-7890", "Customer phone number should be initialized correctly.");
        assertEquals(customer.getEmail(), "johndoe@example.com", "Customer email should be initialized correctly.");
        assertEquals(customer.getAddress(), "123 Main St", "Customer address should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testBuyBook() {
        // Simulate buying a book
        customer.buyBook(book);
        // This test primarily ensures no exceptions are thrown during execution.
    }

    @Test(priority = 3)
    public void testReturnBook() {
        // Simulate returning a book
        customer.returnBook();
        // This test primarily ensures no exceptions are thrown during execution.
    }
}
