package tests;

import classes.ShipFedex2Day;
import enums.SHIPPING_CHOICE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ShipFedex2DayTest {

    private ShipFedex2Day shipFedex2Day;

    @BeforeTest
    public void setUp() {
        shipFedex2Day = new ShipFedex2Day();
    }

    @Test(priority = 1)
    public void testGetShippingCost() {
        assertEquals(shipFedex2Day.getShippingCost(), 15.99f, 0.01, "Shipping cost should be 15.99 for FedEx 2-Day.");
    }

    @Test(priority = 2)
    public void testGetShippingChoice() {
        assertEquals(shipFedex2Day.getShippingChoice(), SHIPPING_CHOICE.FEDEX_2_DAY.toString(), "Shipping choice should be FEDEX_2_DAY.");
    }

    @Test(priority = 3)
    public void testShipOrder() {
        shipFedex2Day.shipOrder();
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}
