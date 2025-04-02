package edu.fgcu.bookstore.models.payment;

import enums.PAYMENT_TYPE;

public class DebitCard extends Card {
    private String bank;

    public DebitCard() {
        super(); // Call the default constructor of Card
    }

    public DebitCard(float paymentAmount, String userName, String cardNumber, String bank) {
        super(paymentAmount, userName, cardNumber);
        this.bank = bank;
    }

    public DebitCard(int orderId, PAYMENT_TYPE paymentMethod, float amount, String cardNumber, String cardHolderName, String expirationDate, String cvv, String bank) {
        super(orderId, paymentMethod, amount, cardNumber, cardHolderName, expirationDate, cvv); // Call the parameterized constructor of Card
        this.bank = bank;
    }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }


    @Override
    public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        System.out.println("Using bank: " + bank);
        Payment payment = new Cash(orderId, paymentMethod, amount);
        // Simulate payment processing logic here
        return payment; // Assume payment is always successful for simplicity
    }

}
