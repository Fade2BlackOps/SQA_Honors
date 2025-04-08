import edu.fgcu.bookstore.models.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ShipUSPSPriorityTest {

    private ShipUSPSPriority shipUSPSPriority;

    @BeforeTest
    public void setUp() {
        shipUSPSPriority = new ShipUSPSPriority();
    }

    @Test(priority = 1)
    public void testGetShippingCost() {
        assertEquals(shipUSPSPriority.getShippingCost(), 15.99f, 0.01, "Shipping cost should be 15.99 for FedEx 2-Day.");
    }

    @Test(priority = 2)
    public void testGetShippingChoice() {
        assertEquals(shipUSPSPriority.getShippingChoice(), SHIPPING_CHOICE.FEDEX_2_DAY.toString(), "Shipping choice should be FEDEX_2_DAY.");
    }

    @Test(priority = 3)
    public void testShipOrder() {
        shipUSPSPriority.shipOrder();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}
