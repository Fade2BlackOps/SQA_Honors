import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;
import edu.fgcu.bookstore.dataTypes.Date;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class OrderTest {

    // DEBUG: Fix whatever is causing the tests to fail

    private Order order;
    private Person customer;
    private Cart cart;
    private ShipMethod shippingMethod;

    @BeforeTest
    public void setUp() {
        customer = new Person("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        cart = new Cart(customer);
        shippingMethod = new ShipMethod("Standard Shipping", 5.99f);
        order = new Order(1, customer, new Date(2025, 3, 24));
        order.setShippingChoice(shippingMethod);
        order.setSubtotal(cart.getTotalPrice());
    }

    @Test(priority = 1)
    public void testOrderConstructor() {
        assertNotNull(order, "Order instance should not be null after construction.");
        assertEquals(order.getOrderId(), 1, "Order ID should be initialized correctly.");
        assertEquals(order.getCustomer(), customer, "Customer should be initialized correctly.");
        assertEquals(order.getOrderDate(), "2025-03-24", "Order date should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetShippingChoice() {
        ShipMethod newShippingMethod = new ShipMethod("Express Shipping", 15.99f);
        order.updateShippingChoice(newShippingMethod);
        assertEquals(order.getShippingChoice(), "Express Shipping", "Shipping choice should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetSubtotal() {
        cart.addBookToCart(new Book("Test Book", "1234567890", null, null, 100, 19.99f, GENRE.FICTION, "path/to/book.docx"), 2);
        order.setSubtotal(cart.getTotalPrice());
        assertEquals(order.getSubtotal(), 39.98f, 0.01, "Subtotal should be updated correctly based on the cart.");
    }

    @Test(priority = 4)
    public void testCalculateTotals() {
        order.updateShippingChoice(shippingMethod);
        assertEquals(order.getTax(), 2.76f, 0.01, "Tax should be calculated correctly.");
        assertEquals(order.getTotal(), 48.73f, 0.01, "Total should be calculated correctly.");
    }

    @Test(priority = 5)
    public void testPlaceOrderWithEmptyCart() {
        Cart emptyCart = new Cart(customer);
        order = new Order(2, customer, new Date(2025, 3, 24));
        order.setShippingChoice(shippingMethod);
        order.setSubtotal(emptyCart.getTotalPrice());
        assertFalse(order.placeOrder(), "Order should not be placed with an empty cart.");
    }

    @Test(priority = 6)
    public void testPlaceOrderWithValidCart() {
        cart.addBookToCart(new Book("Test Book", "1234567890", null, null, 100, 19.99f, GENRE.FICTION, "path/to/book.docx"), 2);
        order.setSubtotal(cart.getTotalPrice());
        Payment payment = new Cash(1, PAYMENT_TYPE.CASH, order.getTotal());
        order.setPayment(payment);
        assertTrue(order.placeOrder(), "Order should be placed successfully with a valid cart and payment.");
    }

    @Test(priority = 7)
    public void testCancelOrder() {
        Payment payment = new Cash(1, PAYMENT_TYPE.CASH, order.getTotal());
        order.setPayment(payment);
        assertTrue(order.cancelOrder(), "Order should be canceled successfully.");
        assertNull(order.getPayment(), "Payment should be reset to null after canceling the order.");
    }

    @Test(priority = 8)
    public void testUpdatePaymentMethod() {
        order.updatePaymentMethod(PAYMENT_TYPE.CREDIT_CARD);
        assertEquals(order.getPayment().getPaymentMethod(), PAYMENT_TYPE.CREDIT_CARD, "Payment method should be updated correctly.");
    }

    @Test(priority = 9)
    public void testToString() {
        String orderString = order.toString();
        assertTrue(orderString.contains("Order ID: 1"), "Order string should contain the correct order ID.");
        assertTrue(orderString.contains("Customer: John Doe"), "Order string should contain the correct customer name.");
        assertTrue(orderString.contains("Subtotal: $0.0"), "Order string should contain the correct subtotal.");
    }
}
