import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PaymentTest {

    private Payment payment;

    // Mock subclass of Payment for testing purposes
    private static class MockPayment extends Payment {
        public MockPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
            super(orderId, paymentMethod, amount);
        }

        @Override
        public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
            // Mock implementation for testing
            return new MockPayment(orderId, paymentMethod, amount);
        }
    }

    @BeforeTest
    public void setUp() {
        payment = new MockPayment(12345, PAYMENT_TYPE.CREDIT_CARD, 100.00f);
    }

    @Test(priority = 1)
    public void testPaymentConstructor() {
        assertNotNull(payment, "Payment instance should not be null after construction.");
        assertEquals(payment.getOrderId(), 12345, "Order ID should be initialized correctly.");
        assertEquals(payment.getPaymentMethod(), PAYMENT_TYPE.CREDIT_CARD, "Payment method should be initialized correctly.");
        assertEquals(payment.getAmount(), 100.00f, 0.01, "Payment amount should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetOrderId() {
        payment.setOrderId(54321);
        assertEquals(payment.getOrderId(), 54321, "Order ID should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetPaymentMethod() {
        payment.setPaymentMethod(PAYMENT_TYPE.DEBIT_CARD);
        assertEquals(payment.getPaymentMethod(), PAYMENT_TYPE.DEBIT_CARD, "Payment method should be updated correctly.");
    }

    @Test(priority = 4)
    public void testSetAmount() {
        payment.setAmount(200.00f);
        assertEquals(payment.getAmount(), 200.00f, 0.01, "Payment amount should be updated correctly.");
    }

    @Test(priority = 5)
    public void testProcessPayment() {
        Payment processedPayment = payment.processPayment(67890, PAYMENT_TYPE.GIFT_CARD, 150.00f);
        assertNotNull(processedPayment, "Processed payment should not be null.");
        assertTrue(processedPayment instanceof MockPayment, "Processed payment should be an instance of MockPayment.");
        assertEquals(processedPayment.getOrderId(), 67890, "Processed payment order ID should match.");
        assertEquals(processedPayment.getPaymentMethod(), PAYMENT_TYPE.GIFT_CARD, "Processed payment method should match.");
        assertEquals(processedPayment.getAmount(), 150.00f, 0.01, "Processed payment amount should match.");
    }
}
