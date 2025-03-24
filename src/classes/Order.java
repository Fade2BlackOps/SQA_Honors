package classes;

import dataTypes.Date;
import enums.PAYMENT_TYPE;

import java.util.Map;

public class Order {

    // Attributes
    // ----------
    public static final float DEFAULT_TAX_RATE = 0.06f; // Default tax rate for orders
    // This can be adjusted as needed for different regions or scenarios

    private int orderId;
    private Person customer;
    private Date orderDate;
    private ShipMethod shippingChoice;
    private float subtotal;
    private float tax = 0.00f; // Default tax value
    private float total;
    private Map<Book, Integer> cartItems;
    private PAYMENT_TYPE paymentType = PAYMENT_TYPE.None; // Default payment type
    private Payment payment;


    public Order(int orderId, Person customer, Date orderDate) {
        this.orderId = orderId;
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
        this.subtotal = subtotal;
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

    public Map<Book, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Book, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    // Methods
    // -----------------------------
    
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

}