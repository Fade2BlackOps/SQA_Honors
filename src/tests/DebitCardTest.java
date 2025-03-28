package tests;

import classes.DebitCard;
import classes.Payment;
import enums.PAYMENT_TYPE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class DebitCardTest {

    private DebitCard debitCard;

    @BeforeTest
    public void setUp() {
        debitCard = new DebitCard(
            12345,
            PAYMENT_TYPE.DEBIT_CARD,
            150.00f,
            "1234-5678-9012-3456",
            "John Doe",
            "12/25",
            "123",
            "Bank of Test"
        );
    }

    @Test(priority = 1)
    public void testDebitCardConstructor() {
        assertNotNull(debitCard, "DebitCard instance should not be null after construction.");
        assertEquals(debitCard.getAmount(), 150.00f, 0.01, "Payment amount should be initialized correctly.");
        assertEquals(debitCard.getUserName(), "John Doe", "User name should be initialized correctly.");
        assertEquals(debitCard.getCardNumber(), "1234-5678-9012-3456", "Card number should be initialized correctly.");
        assertEquals(debitCard.getBank(), "Bank of Test", "Bank should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testSetBank() {
        debitCard.setBank("New Bank");
        assertEquals(debitCard.getBank(), "New Bank", "Bank should be updated correctly.");
    }

    @Test(priority = 3)
    public void testProcessPayment() {
        Payment processedPayment = debitCard.processPayment(67890, PAYMENT_TYPE.DEBIT_CARD, 200.00f);
        assertNotNull(processedPayment, "Processed payment should not be null.");
        assertTrue(processedPayment instanceof DebitCard, "Processed payment should be an instance of DebitCard.");
        assertEquals(processedPayment.getAmount(), 200.00f, 0.01, "Processed payment amount should match.");
        assertEquals(processedPayment.getPaymentMethod(), PAYMENT_TYPE.DEBIT_CARD, "Processed payment method should be DEBIT_CARD.");
    }
}
