package classes;

import enums.SHIPPING_CHOICE;

public class ShipFedex2Day extends ShipMethod {

    // Attributes
    // -------------------------------------------------------------------------
    private final float shippingCost = 15.99f; // Fixed shipping cost for FedEx 2-Day
    private final SHIPPING_CHOICE shippingChoice = SHIPPING_CHOICE.FEDEX_2_DAY; // Shipping choice enum value

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

}