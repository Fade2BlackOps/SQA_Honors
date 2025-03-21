package classes;

import interfaces.ShippingChoice;

public class ShipUSPSPriority implements ShippingChoice {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 10.50f; // Fixed shipping cost for USPS Priority


    // Getters and Setters
    // -------------------------------------------------------------------------
    // No getters and setters needed for this class as we are using a fixed shipping cost


    // Methods
    // -------------------------------------------------------------------------


    @Override
    public void shipOrder() {
        // Simulate the process of shipping an order with USPS Priority
        System.out.println("Shipping order using USPS Priority...");
        System.out.println("Shipping cost: $" + shippingCost);
        // Here you would typically update the order status and notify the customer
        // return order_id; or smthn like that
    }

    @Override
    public float getShippingCost(String method) {
        // Return the shipping cost for USPS Priority
        if ("USPS Priority".equalsIgnoreCase(method)) {
            return shippingCost;
        }
        return 0.0f; // Return 0 for other methods (or throw an exception if needed)
    } 
    

}