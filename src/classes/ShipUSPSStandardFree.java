package classes;

public class ShipUSPSStandardFree extends ShipMethod {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 0.00f; // Fixed shipping cost for USPS Standard Free


    // Getters and Setters
    // -------------------------------------------------------------------------
    // No getters and setters needed for this class as we are using a fixed shipping cost


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