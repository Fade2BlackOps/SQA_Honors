package classes;

import enums.PAYMENT_TYPE;

public class Payment {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private PAYMENT_TYPE paymentMethod;
    private float amount;

    // Constructors
    // ----------------------
    public Payment() {  
        this.paymentMethod = PAYMENT_TYPE.None; // Default to None
        this.amount = 0.0f; // Default amount
    }

    public Payment(PAYMENT_TYPE paymentMethod, float amount) {
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
     * @return true if payment is successful, false otherwise.
     */
    public boolean processPayment() {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        // Simulate payment processing logic here
        return true; // Assume payment is always successful for simplicity
    }

}