package tests.classes;

import classes.CreditCard;
import classes.Payment;
import enums.PAYMENT_TYPE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CreditCardTest {

    private CreditCard creditCard;

    @BeforeTest
    public void setUp() {
        creditCard = new CreditCard(
            100.00f,
            "John Doe",
            "1234-5678-9012-3456",
            "Visa",
            123
        );
    }

    @Test(priority = 1)
    public void testCreditCardConstructor() {
        assertNotNull(creditCard, "CreditCard instance should not be null after construction.");
        assertEquals(creditCard.getAmount(), 100.00f, 0.01, "Payment amount should be initialized correctly.");
        assertEquals(creditCard.getUserName(), "John Doe", "User name should be initialized correctly.");
        assertEquals(creditCard.getCardNumber(), "1234-5678-9012-3456", "Card number should be initialized correctly.");
        assertEquals(creditCard.getProcessingNetwork(), "Visa", "Processing network should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testProcessPayment() {
        Payment processedPayment = creditCard.processPayment(67890, PAYMENT_TYPE.CREDIT_CARD, 200.00f);
        assertNotNull(processedPayment, "Processed payment should not be null.");
        assertTrue(processedPayment instanceof CreditCard, "Processed payment should be an instance of CreditCard.");
        assertEquals(processedPayment.getAmount(), 200.00f, 0.01, "Processed payment amount should match.");
        assertEquals(processedPayment.getPaymentMethod(), PAYMENT_TYPE.CREDIT_CARD, "Processed payment method should be CREDIT_CARD.");
    }
}
