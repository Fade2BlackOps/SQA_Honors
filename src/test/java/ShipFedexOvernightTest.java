package tests;

import classes.ShipFedexOvernight;
import enums.SHIPPING_CHOICE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ShipFedexOvernightTest {

    private ShipFedexOvernight shipFedexOvernight;

    @BeforeTest
    public void setUp() {
        shipFedexOvernight = new ShipFedexOvernight();
    }

    @Test(priority = 1)
    public void testGetShippingCost() {
        assertEquals(shipFedexOvernight.getShippingCost(), 15.99f, 0.01, "Shipping cost should be 15.99 for FedEx 2-Day.");
    }

    @Test(priority = 2)
    public void testGetShippingChoice() {
        assertEquals(shipFedexOvernight.getShippingChoice(), SHIPPING_CHOICE.FEDEX_2_DAY.toString(), "Shipping choice should be FEDEX_2_DAY.");
    }

    @Test(priority = 3)
    public void testShipOrder() {
        shipFedexOvernight.shipOrder();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}
