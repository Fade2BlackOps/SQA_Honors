package classes;

import dataTypes.Date;
import interfaces.ShippingHandler;
import java.util.Map;

public class Order {

    // Attributes
    // ----------
    public static final float DEFAULT_TAX_RATE = 0.06f; // Default tax rate for orders
    // This can be adjusted as needed for different regions or scenarios

    private int orderId;
    private Person customer;
    private Date orderDate;
    private ShippingHandler shippingChoice;
    private float subtotal;
    private float tax = 0.00f; // Default tax value
    private float total;
    private Map<Book, Integer> cartItems;
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

    public ShippingHandler getShippingChoice() {
        return shippingChoice;
    }

    public void setShippingChoice(ShippingHandler shippingChoice) {
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

    private void setTax(float subtotal, float shippingCost) {
        this.tax = Math.round(subtotal * DEFAULT_TAX_RATE); // Calculate tax based on subtotal and default tax rate
        // FIXME: Make sure this is rounded to 2 decimal places
    }

    public float getTotal() {
        return total;
    }

    private void setTotal(float subtotal, float tax) {
        this.total = Math.round(subtotal + tax); // Calculate total as subtotal plus tax
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
    


}