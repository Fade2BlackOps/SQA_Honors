package interfaces;

public interface ShippingChoice {

    /**
     * Simulates a shipping choice for a book.
     * 
     * @return the shipping method chosen
     */
    String chooseShippingMethod();

    /**
     * Simulates a shipping cost calculation based on the chosen method.
     * 
     * @param method the shipping method chosen
     * @return the calculated shipping cost
     */
    float calculateShippingCost(String method);
}