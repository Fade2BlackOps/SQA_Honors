package tests.classes;

import classes.Cart;
import classes.Book;
import classes.Customer;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CartTest {

    private Cart cart;
    private Customer customer;
    private Book book1;
    private Book book2;

    @BeforeTest
    public void setUp() {
        customer = new Customer("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        cart = new Cart(customer);

        book1 = new Book("Book One", "1111", null, null, 100, 10.99f, GENRE.FICTION, "path/to/book1.docx");
        book2 = new Book("Book Two", "2222", null, null, 200, 15.99f, GENRE.NON_FICTION, "path/to/book2.docx");
    }

    @Test(priority = 1)
    public void testCartConstructor() {
        assertNotNull(cart, "Cart instance should not be null after construction.");
        assertEquals(cart.getCustomer(), customer);
        assertTrue(cart.getItems().isEmpty(), "Cart should be empty upon initialization.");
        assertEquals(cart.getTotalPrice(), 0.00f, 0.01, "Total price should be 0.00 upon initialization.");
    }

    @Test(priority = 2)
    public void testAddBookToCart() {
        cart.addBookToCart(book1, 2);
        assertEquals(cart.getItems().get(book1).intValue(), 2, "Cart should contain 2 copies of book1.");
        assertEquals(cart.getTotalPrice(), 21.98f, 0.01, "Total price should be updated correctly.");
    }

    @Test(priority = 3)
    public void testAddMultipleBooksToCart() {
        cart.addBookToCart(book1, 1);
        cart.addBookToCart(book2, 3);
        assertEquals(cart.getItems().get(book1).intValue(), 1, "Cart should contain 1 copy of book1.");
        assertEquals(cart.getItems().get(book2).intValue(), 3, "Cart should contain 3 copies of book2.");
        assertEquals(cart.getTotalPrice(), 57.96f, 0.01, "Total price should be updated correctly.");
    }

    @Test(priority = 4)
    public void testRemoveBookFromCart() {
        cart.addBookToCart(book1, 2);
        cart.removeBookFromCart(book1);
        assertFalse(cart.getItems().containsKey(book1), "Book1 should be removed from the cart.");
        assertEquals(cart.getTotalPrice(), 0.00f, 0.01, "Total price should be updated after removing the book.");
    }

    @Test(priority = 5)
    public void testCalculateTotalPrice() {
        cart.addBookToCart(book1, 1);
        cart.addBookToCart(book2, 2);
        float expectedTotal = (1 * book1.getPrice()) + (2 * book2.getPrice());
        assertEquals(cart.calculateTotalPrice(), expectedTotal, 0.01, "Total price should be calculated correctly.");
    }

    @Test(priority = 6)
    public void testDisplayCartContents() {
        cart.addBookToCart(book1, 1);
        cart.addBookToCart(book2, 2);
        cart.displayCartContents();
        // This test primarily ensures no exceptions are thrown during execution.
    }

    @Test(priority = 7)
    public void testClearCart() {
        cart.addBookToCart(book1, 1);
        cart.addBookToCart(book2, 2);
        cart.clearCart();
        assertTrue(cart.getItems().isEmpty(), "Cart should be empty after clearing.");
        assertEquals(cart.getTotalPrice(), 0.00f, 0.01, "Total price should be reset to 0.00 after clearing the cart.");
    }

    @Test(priority = 8)
    public void testIsEmpty() {
        assertTrue(cart.isEmpty(), "Cart should be empty initially.");
        cart.addBookToCart(book1, 1);
        assertFalse(cart.isEmpty(), "Cart should not be empty after adding a book.");
        cart.clearCart();
        assertTrue(cart.isEmpty(), "Cart should be empty after clearing.");
    }

    @Test(priority = 9)
    public void testToString() {
        cart.addBookToCart(book1, 1);
        String cartString = cart.toString();
        assertTrue(cartString.contains("Book One"), "Cart string should contain book1 details.");
        assertTrue(cartString.contains("Total Price: $10.99"), "Cart string should contain the correct total price.");
    }
}
