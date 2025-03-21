package classes;

import interfaces.ShippingChoice;

public class ShipFedex2Day implements ShippingChoice {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 15.99f; // Fixed shipping cost for FedEx 2-Day

    // Getters and Setters
    // -------------------------------------------------------------------------
    // No getters and setters needed for this class as we are using a fixed shipping cost

    // Methods
    // -------------------------------------------------------------------------

    /**
     * Simulates the process of shipping an order using FedEx 2-Day.
     * This method would typically involve updating the order status and
     * notifying the customer about the shipping details.
     */
    @Override
    public void shipOrder() {
        // Simulate the process of shipping an order with FedEx 2-Day
        System.out.println("Shipping order using FedEx 2-Day...");
        System.out.println("Shipping cost: $" + shippingCost);
        // Here you would typically update the order status and notify the customer
        // return order_id; or smthn like that
    }

    @Override
    public float getShippingCost(String method) {
        // Return the shipping cost for FedEx 2-Day
        if ("FedEx 2-Day".equalsIgnoreCase(method)) {
            return shippingCost;
        }
        return 0.0f; // Return 0 for other methods (or throw an exception if needed)
    } 
    

}