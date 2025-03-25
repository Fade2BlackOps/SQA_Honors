package tests.classes;

import classes.GiftCard;
import classes.Payment;
import enums.PAYMENT_TYPE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class GiftCardTest {

    private GiftCard giftCard;

    @BeforeTest
    public void setUp() {
        giftCard = new GiftCard(100.00f, "John Doe", "1234-5678-9012-3456", 50.00f);
    }

    @Test(priority = 1)
    public void testGiftCardConstructor() {
        assertNotNull(giftCard, "GiftCard instance should not be null after construction.");
        assertEquals(giftCard.getBalance(), 50.00f, 0.01, "Initial balance should be initialized correctly.");
        assertEquals(giftCard.getUserName(), "John Doe", "User name should be initialized correctly.");
        assertEquals(giftCard.getCardNumber(), "1234-5678-9012-3456", "Card number should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testAddFunds() {
        giftCard.addFunds(25.00f);
        assertEquals(giftCard.getBalance(), 75.00f, 0.01, "Balance should be updated correctly after adding funds.");
    }

    @Test(priority = 3)
    public void testDeductFunds() {
        giftCard.deductFunds(20.00f);
        assertEquals(giftCard.getBalance(), 30.00f, 0.01, "Balance should be updated correctly after deducting funds.");
    }

    @Test(priority = 4)
    public void testHasSufficientBalance() {
        assertTrue(giftCard.hasSufficientBalance(30.00f), "Gift card should have sufficient balance for the amount.");
        assertFalse(giftCard.hasSufficientBalance(60.00f), "Gift card should not have sufficient balance for the amount.");
    }

    @Test(priority = 5)
    public void testResetBalance() {
        giftCard.resetBalance();
        assertEquals(giftCard.getBalance(), 0.00f, 0.01, "Balance should be reset to zero.");
    }

    @Test(priority = 6)
    public void testProcessPaymentWithSufficientBalance() {
        Payment processedPayment = giftCard.processPayment(12345, PAYMENT_TYPE.GIFT_CARD, 25.00f);
        assertNotNull(processedPayment, "Processed payment should not be null.");
        assertEquals(giftCard.getBalance(), 25.00f, 0.01, "Balance should be updated correctly after processing payment.");
        assertEquals(processedPayment.getAmount(), 25.00f, 0.01, "Processed payment amount should match.");
    }

    @Test(priority = 7)
    public void testProcessPaymentWithInsufficientBalance() {
        Payment processedPayment = giftCard.processPayment(12345, PAYMENT_TYPE.GIFT_CARD, 60.00f);
        assertNull(processedPayment, "Processed payment should be null due to insufficient balance.");
        assertEquals(giftCard.getBalance(), 50.00f, 0.01, "Balance should remain unchanged after failed payment.");
    }

    @Test(priority = 8)
    public void testToString() {
        String giftCardString = giftCard.toString();
        assertTrue(giftCardString.contains("balance=50.0"), "Gift card string should contain the correct balance.");
    }
}
