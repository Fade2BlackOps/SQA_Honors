package classes;

import enums.PAYMENT_TYPE;

public class Cash extends Payment {
    public Cash() {
        super(); // Call the default constructor of Payment
    }

    public Cash(float paymentAmount) {
        super(paymentAmount);
    }

    public Cash(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        super(orderId, paymentMethod, amount); // Call the parameterized constructor of Payment
    }

    public Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount) {
        System.out.println("Processing " + paymentMethod + " payment of $" + amount);
        Payment payment = new Cash(orderId, paymentMethod, amount);
        // Simulate payment processing logic here
        return payment; // Assume payment is always successful for simplicity
    }

}
