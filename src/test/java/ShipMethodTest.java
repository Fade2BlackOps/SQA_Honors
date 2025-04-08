import edu.fgcu.bookstore.models.shipping.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ShipMethodTest {

    private ShipMethod shipMethod;

    // Mock subclass of ShipMethod for testing purposes
    private static class MockShipMethod extends ShipMethod {
        public MockShipMethod(float shippingCost, SHIPPING_CHOICE shippingChoice) {
            this.shippingCost = shippingCost;
            this.shippingChoice = shippingChoice;
        }

        @Override
        public void shipOrder() {
            // Mock implementation for testing
            System.out.println("Shipping order using " + shippingChoice + "...");
        }
    }

    @BeforeTest
    public void setUp() {
        shipMethod = new MockShipMethod(10.99f, SHIPPING_CHOICE.USPS_STANDARD_FREE);
    }

    @Test(priority = 1)
    public void testGetShippingCost() {
        assertEquals(shipMethod.getShippingCost(), 10.99f, 0.01, "Shipping cost should be initialized correctly.");
    }

    @Test(priority = 2)
    public void testGetShippingChoice() {
        assertEquals(shipMethod.getShippingChoice(), SHIPPING_CHOICE.USPS_STANDARD_FREE.toString(), "Shipping choice should be initialized correctly.");
    }

    @Test(priority = 3)
    public void testShipOrder() {
        shipMethod.shipOrder();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}
