package tests.classes;

import classes.Card;
import classes.Payment;
import enums.PAYMENT_TYPE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CardTest {

    private Card card;

    // Mock subclass of Card for testing purposes
    private static class MockCard extends Card {
        public MockCard(int orderId, PAYMENT_TYPE paymentMethod, float amount, String cardNumber, String cardHolderName, String expirationDate, String cvv) {
            super(orderId, paymentMethod, amount, cardNumber, cardHolderName, expirationDate, cvv);
        }

        @Override
        public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
            // Mock implementation for testing
            return this;
        }
    }

    @BeforeTest
    public void setUp() {
        card = new MockCard(
            12345,
            PAYMENT_TYPE.CREDIT_CARD,
            100.50f,
            "1234-5678-9012-3456",
            "John Doe",
            "12/25",
            "123"
        );
    }

    @Test(priority = 1)
    public void testCardConstructor() {
        assertNotNull(card, "Card instance should not be null after construction.");
        assertEquals(card.getCardNumber(), "1234-5678-9012-3456");
        assertEquals(card.getCardHolderName(), "John Doe");
        assertEquals(card.getExpirationDate(), "12/25");
        assertEquals(card.getCvv(), "123");
        assertEquals(card.getUserName(), null); // Default value
    }

    @Test(priority = 2)
    public void testSetCardNumber() {
        card.setCardNumber("9876-5432-1098-7654");
        assertEquals(card.getCardNumber(), "9876-5432-1098-7654");
    }

    @Test(priority = 3)
    public void testSetCardHolderName() {
        card.setCardHolderName("Jane Doe");
        assertEquals(card.getCardHolderName(), "Jane Doe");
    }

    @Test(priority = 4)
    public void testSetExpirationDate() {
        card.setExpirationDate("01/30");
        assertEquals(card.getExpirationDate(), "01/30");
    }

    @Test(priority = 5)
    public void testSetCvv() {
        card.setCvv("456");
        assertEquals(card.getCvv(), "456");
    }

    @Test(priority = 6)
    public void testSetUserName() {
        card.setUserName("johndoe");
        assertEquals(card.getUserName(), "johndoe");
    }

    @Test(priority = 7)
    public void testGetMaskedCardNumber() {
        card.setCardNumber("1234-5678-9012-7654");
        assertEquals(card.getMaskedCardNumber(), "****-****-****-7654");
        card.setCardNumber("1234");
        assertEquals(card.getMaskedCardNumber(), "1234"); // Too short to mask
    }

    @Test(priority = 8)
    public void testProcessPayment() {
        Payment payment = card.processPayment(12345, PAYMENT_TYPE.CREDIT_CARD, 100.50f);
        assertNotNull(payment, "Payment should not be null after processing.");
        assertEquals(payment.getAmount(), 100.50f, 0.01);
    }
}
