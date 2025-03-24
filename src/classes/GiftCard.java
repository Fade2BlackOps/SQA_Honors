package classes;

import enums.PAYMENT_TYPE;

public class GiftCard extends Card {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private float balance;

    // Constructors
    // -------------------------------------------------------------------------
    public GiftCard() {
        this.balance = 0.0f; // Default balance
    }

    public GiftCard(float initialBalance) {
        this.balance = initialBalance;
    }

    public GiftCard(float paymentAmount, String userName, String cardNumber, float cardBalance) {
        super(paymentAmount, userName, cardNumber);
        this.balance = cardBalance;
    }

    // Getters and Setters
    // -------------------------------------------------------------------------
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    // Methods
    // -------------------------------------------------------------------------
    
    /**
     * Adds an amount to the gift card balance.
     * 
     * @param amount the amount to add
     */
    public void addFunds(float amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    /**
     * Deducts an amount from the gift card balance.
     * 
     * @param amount the amount to deduct
     */
    public void deductFunds(float amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    /**
     * Checks if the gift card has sufficient balance for a purchase.
     * 
     * @param amount the amount to check
     * @return true if sufficient balance, false otherwise
     */
    public boolean hasSufficientBalance(float amount) {
        return amount > 0 && amount <= this.balance;
    }

    /**
     * Resets the gift card balance to zero.
     */
    public void resetBalance() {
        this.balance = 0.0f;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        if (hasSufficientBalance(amount)) {
            deductFunds(amount);
            System.out.println("Processing " + paymentMethod + " payment of $" + amount);
            Payment payment = new Cash(orderId, paymentMethod, amount);
            return payment; // Assume payment is always successful for simplicity
        } else {
            System.out.println("Insufficient balance on the gift card.");
            return null; // Payment cannot be processed due to insufficient balance
        }
    }
    
}
