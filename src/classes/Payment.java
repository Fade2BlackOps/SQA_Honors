package classes;

public class Payment {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String paymentMethod; // e.g., Credit Card, PayPal
    // TODO: Change to enum for better type safety
    // private PaymentMethod paymentMethod; // Enum for payment methods
    private float amount; // Amount to be paid

    // Constructors
    // ----------------------
    public Payment() {}

    public Payment(String paymentMethod, float amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    // Getters and Setters
    // --------
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    // Methods
    // --------------
    
    /**
     * Processes the payment.
     * @return true if payment is successful, false otherwise.
     */
    public boolean processPayment() {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        // Simulate payment processing logic here
        return true; // Assume payment is always successful for simplicity
    }

}