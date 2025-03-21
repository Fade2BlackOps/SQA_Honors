package interfaces;

public interface ShippingChoice {

    /**
     * Simulates the process of shipping an order.
     * This method would typically involve updating the order status and
     * notifying the customer about the shipping details.
     */
    void shipOrder();

    /**
     * Simulates a shipping cost calculation based on the chosen method.
     * 
     * @param method the shipping method chosen
     * 
     * @return the calculated shipping cost
     */
    float getShippingCost(String method); // TODO: // Change to enum for shipping methods
}