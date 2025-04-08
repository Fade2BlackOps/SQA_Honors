package edu.fgcu.bookstore.models.shipping;

import edu.fgcu.bookstore.enums.SHIPPING_CHOICE;

public class ShipUSPSStandardFree extends ShipMethod {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 0.00f; // Fixed shipping cost for USPS Standard Free
    private final SHIPPING_CHOICE shippingChoice = SHIPPING_CHOICE.USPS_STANDARD_FREE; // Shipping choice enum value

    public ShipUSPSStandardFree(String string, float f) {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    // -------------------------------------------------------------------------
    public float getShippingCost() {
        return shippingCost;
    }

    public String getShippingChoice() {
        return shippingChoice.toString(); // Return the string representation of the shipping choice
    }


    // Methods
    // -------------------------------------------------------------------------

    /**
     * Simulates the process of shipping an order using USPS Standard Free.
     * This method would typically involve updating the order status and
     * notifying the customer about the shipping details.
     */
    @Override
    public void shipOrder() {
        // Simulate the process of shipping an order with USPS Standard Free
        System.out.println("Shipping order using USPS Standard Free...");
        System.out.println("Shipping cost: $" + shippingCost);
        // Here you would typically update the order status and notify the customer
        // return order_id; or smthn like that
    }

}