package classes;

import interfaces.ShippingChoice;

public class ShipFedexOvernight implements ShippingChoice {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 25.99f; // Fixed shipping cost for FedEx Overnight


    // Methods
    // -------------------------------------------------------------------------


    @Override
    public void shipOrder() {
        // Simulate the process of shipping an order with FedEx Overnight
        System.out.println("Shipping order using FedEx Overnight...");
        System.out.println("Shipping cost: $" + shippingCost);
        // Here you would typically update the order status and notify the customer
        // return order_id; or smthn like that
    }

    @Override
    public float getShippingCost(String method) {
        // Return the shipping cost for FedEx Overnight
        if ("FedEx Overnight".equalsIgnoreCase(method)) {
            return shippingCost;
        }
        return 0.0f; // Return 0 for other methods (or throw an exception if needed)
    } 
    

}