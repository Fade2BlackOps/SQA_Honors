package classes;

import dataTypes.Date;
import enums.PAYMENT_TYPE;

import java.util.Map;

public class Order {

    // Attributes
    // ----------
    public static final float DEFAULT_TAX_RATE = 0.06f; // Default tax rate for orders
    // This can be adjusted as needed for different regions or scenarios
    private static int orderCounter = 0; // Static counter to generate unique order IDs

    private int orderId;
    private Person customer;
    private Date orderDate;
    private ShipMethod shippingChoice;
    private float subtotal;
    private float tax = 0.00f; // Default tax value
    private float total;
    private Cart cart;
    private PAYMENT_TYPE paymentType = PAYMENT_TYPE.None; // Default payment type
    private Payment payment;


    public Order(int orderId, Person customer, Date orderDate) {
        this.orderId = generateOrderId(); // Generate a unique order ID
        this.customer = customer;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    // -----------------------------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return orderDate.toString();
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingChoice() {
        return shippingChoice.getShippingChoice();
    }

    public void setShippingChoice(ShipMethod shippingChoice) {
        this.shippingChoice = shippingChoice;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = cart.getTotalPrice(); // Calculate subtotal based on the cart's total price
    }

    public float getTax() {
        return tax;
    }

    private void setTax(float subtotal, ShipMethod shippingMethod) {
        float preTax = subtotal + shippingMethod.getShippingCost(); // Calculate pre-tax total
        this.tax = Math.round(preTax * DEFAULT_TAX_RATE); // Calculate tax based on subtotal and default tax rate
        // FIXME: Make sure this is rounded to 2 decimal places
    }

    public float getTotal() {
        return total;
    }

    private void setTotal(float subtotal, ShipMethod shippingMethod, float tax) {
        this.total = Math.round(subtotal + shippingMethod.getShippingCost() + tax);
        // FIXME: Make sure this is rounded to 2 decimal places
    }

    public Cart getCart() {
        return cart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    // Methods
    // -----------------------------
    
    /**
     * Generates a unique order ID for each order.
     * This method is synchronized to ensure thread safety when multiple orders are created simultaneously.
     * 
     * @return a unique order ID
     */
    private static synchronized int generateOrderId() {
        return ++orderCounter; // Increment the static counter and return the new value as the order ID
    }

    private void calculateTotals() {
        if (shippingChoice != null) {
            setTax(subtotal, shippingChoice); // Calculate tax based on subtotal and shipping method
            setTotal(subtotal, shippingChoice, tax); // Calculate total based on subtotal, shipping cost, and tax
        }
    }

    /**
     * Processes the order by calculating totals and updating the payment status.
     */
    private Payment processOrderPayment() {
        calculateTotals(); // Calculate totals before processing payment
        if (payment != null) {
            payment.processPayment(orderId, paymentType, total); // Process payment with the total amount
        }
        return payment; // Return the payment object for further processing or confirmation
    }

    /**
     * Places the order by processing the payment and updating the order status.
     * 
     * @return true if the order is successfully placed, false otherwise
     */
    public boolean placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return false; // Cannot place order if cart is empty
        }
        Payment payment = processOrderPayment(); // Process the payment for the order
        if (payment != null) {
            System.out.println("Order placed successfully with ID: " + orderId);
            return true; // Order placed successfully
        }
        System.out.println("Failed to place order.");
        return false; // Order placement failed
    }

    /**
     * Cancels the order by resetting the payment and order details.
     * 
     * @return true if the order is successfully canceled, false otherwise
     */
    public boolean cancelOrder() {
        if (payment != null) {
            payment = null; // Reset payment to null
            System.out.println("Order with ID: " + orderId + " has been canceled.");
            return true; // Order canceled successfully
        }
        System.out.println("No payment found. Cannot cancel order.");
        return false; // Cannot cancel order if no payment exists
    }

    /**
     * Updates the payment method for the order.
     * 
     * @param paymentType the new payment method to be set
     */
    public void updatePaymentMethod(PAYMENT_TYPE paymentType) {
        this.paymentType = paymentType; // Update the payment method
        if (payment != null) {
            payment.setPaymentMethod(paymentType); // Update the payment object with the new method
        }
    }

    /**
     * Updates the shipping choice for the order.
     * 
     * @param shippingChoice the new shipping method to be set
     */
    public void updateShippingChoice(ShipMethod shippingChoice) {
        this.shippingChoice = shippingChoice; // Update the shipping choice
        calculateTotals(); // Recalculate totals based on the new shipping method
    }

    /**
     * Returns a string representation of the order details.
     * 
     * @return a string containing order information
     */
    public String toString() {
        return "Order ID: " + orderId +
                "\nCustomer: " + customer.getName() +
                "\nOrder Date: " + orderDate +
                "\nShipping Choice: " + getShippingChoice() +
                "\nSubtotal: $" + subtotal +
                "\nTax: $" + tax +
                "\nTotal: $" + total +
                "\nPayment Method: " + paymentType;
    }

}