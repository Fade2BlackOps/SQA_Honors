package classes;

import interfaces.ShippingHandler;

public abstract class ShipMethod implements ShippingHandler {
    // Attributes
    // -------------------------------------------------------------------------
    protected float shippingCost; // Variable to hold the shipping cost

    // Getters and Setters
    // -------------------------------------------------------------------------
    public float getShippingCost() {
        return shippingCost;
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
