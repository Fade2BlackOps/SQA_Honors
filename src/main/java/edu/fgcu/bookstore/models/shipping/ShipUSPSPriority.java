package edu.fgcu.bookstore.models.shipping;

import enums.SHIPPING_CHOICE;

public class ShipUSPSPriority extends ShipMethod {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 10.50f; // Fixed shipping cost for USPS Priority
    private final SHIPPING_CHOICE shippingChoice = SHIPPING_CHOICE.USPS_PRIORITY; // Shipping choice enum value


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
     * Simulates the process of shipping an order using USPS Priority.
     * This method would typically involve updating the order status and
     * notifying the customer about the shipping details.
     */
    @Override
    public void shipOrder() {
        // Simulate the process of shipping an order with USPS Priority
        System.out.println("Shipping order using USPS Priority...");
        System.out.println("Shipping cost: $" + shippingCost);
        // Here you would typically update the order status and notify the customer
        // return order_id; or smthn like that
    }

}