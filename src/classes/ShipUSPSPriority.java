package classes;

public class ShipUSPSPriority extends ShipMethod {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 10.50f; // Fixed shipping cost for USPS Priority


    // Getters and Setters
    // -------------------------------------------------------------------------
    // No getters and setters needed for this class as we are using a fixed shipping cost


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