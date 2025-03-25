package classes;

import enums.PAYMENT_TYPE;

public class CreditCard extends Card {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String processingNetwork;
    private int securityCode;

    // Constructors
    // ----------------------
    public CreditCard() {
        super(); // Call the default constructor of Card
    }

    public CreditCard(float paymentAmount, String userName, String cardNumber, String processingNetwork, int securityCode) {
        super(paymentAmount, userName, cardNumber);
        this.processingNetwork = processingNetwork;
        this.securityCode = securityCode;
    }

    public String getProcessingNetwork() {
        return processingNetwork;
    }



    @Override
    public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        System.out.println("Using processing network: " + processingNetwork);
        System.out.println("Security code: " + securityCode);
        Payment payment = new Cash(orderId, paymentMethod, amount);
        // Simulate payment processing logic here
        return payment; // Assume payment is always successful for simplicity
    }
}
