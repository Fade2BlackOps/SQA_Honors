package edu.fgcu.bookstore.models.shipping;

import interfaces.ShippingHandler;
import enums.SHIPPING_CHOICE;

public abstract class ShipMethod implements ShippingHandler {
    // Attributes
    // -------------------------------------------------------------------------
    protected float shippingCost; // Variable to hold the shipping cost
    protected SHIPPING_CHOICE shippingChoice; // Variable to hold the shipping choice

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
     * Simulates the process of shipping an order.
     * This method would typically involve updating the order status and
     * notifying the customer about the shipping details.
     */
    @Override
    public abstract void shipOrder();
    
}
