import edu.fgcu.bookstore.models.payment.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CashTest {

    private Cash cash;

    @BeforeTest
    public void setUp() {
        cash = new Cash(12345, PAYMENT_TYPE.CASH, 50.00f);
    }

    @Test(priority = 1)
    public void testCashConstructor() {
        assertNotNull(cash, "Cash instance should not be null after construction.");
        assertEquals(cash.getAmount(), 50.00f, 0.01, "Payment amount should be initialized correctly.");
        assertEquals(cash.getPaymentMethod(), PAYMENT_TYPE.CASH, "Payment method should be CASH.");
        assertEquals(cash.getOrderId(), 12345, "Order ID should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetPaymentAmount() {
        cash.setAmount(75.00f);
        assertEquals(cash.getAmount(), 75.00f, 0.01, "Payment amount should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetOrderId() {
        cash.setOrderId(54321);
        assertEquals(cash.getOrderId(), 54321, "Order ID should be updated correctly.");
    }

    @Test(priority = 4)
    public void testProcessPayment() {
        Payment processedPayment = cash.processPayment(67890, PAYMENT_TYPE.CASH, 100.00f);
        assertNotNull(processedPayment, "Processed payment should not be null.");
        assertTrue(processedPayment instanceof Cash, "Processed payment should be an instance of Cash.");
        assertEquals(processedPayment.getAmount(), 100.00f, 0.01, "Processed payment amount should match.");
        assertEquals(processedPayment.getPaymentMethod(), PAYMENT_TYPE.CASH, "Processed payment method should be CASH.");
        assertEquals(processedPayment.getOrderId(), 67890, "Processed payment order ID should match.");
    }
}
