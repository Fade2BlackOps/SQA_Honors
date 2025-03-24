package classes;

import enums.PAYMENT_TYPE;

public class Payment {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private int orderId; // Unique identifier for the order associated with this payment
    // This can be used to link the payment to a specific order
    private PAYMENT_TYPE paymentMethod;
    private float amount;

    // Constructors
    // ----------------------
    public Payment() {  
        this.paymentMethod = PAYMENT_TYPE.None; // Default to None
        this.amount = 0.0f; // Default amount
    }

    public Payment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        this.orderId = orderId; // Set the order ID
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    // Getters and Setters
    // --------
    public PAYMENT_TYPE getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PAYMENT_TYPE paymentMethod) { this.paymentMethod = paymentMethod; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    // Methods
    // --------------
    
    /**
     * Processes the payment.
     * This method simulates the payment processing logic.
     * 
     * @param paymentMethod the method of payment (e.g., credit card, PayPal)
     * @param amount the amount to be charged
     * 
     * @return true if payment is successful, false otherwise.
     */
    public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        Payment payment = new Payment(orderId, paymentMethod, amount);
        // Simulate payment processing logic here
        return payment; // Assume payment is always successful for simplicity
    }

}