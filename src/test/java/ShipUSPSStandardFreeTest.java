import edu.fgcu.bookstore.models.shipping.*;
import edu.fgcu.bookstore.enums.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ShipUSPSStandardFreeTest {

    private ShipUSPSStandardFree shipUSPSStandardFree;

    @BeforeTest
    public void setUp() {
        shipUSPSStandardFree = new ShipUSPSStandardFree();
    }

    @Test(priority = 1)
    public void testGetShippingCost() {
        assertEquals(shipUSPSStandardFree.getShippingCost(), 15.99f, 0.01, "Shipping cost should be 15.99 for FedEx 2-Day.");
    }

    @Test(priority = 2)
    public void testGetShippingChoice() {
        assertEquals(shipUSPSStandardFree.getShippingChoice(), SHIPPING_CHOICE.FEDEX_2_DAY.toString(), "Shipping choice should be FEDEX_2_DAY.");
    }

    @Test(priority = 3)
    public void testShipOrder() {
        shipUSPSStandardFree.shipOrder();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}
