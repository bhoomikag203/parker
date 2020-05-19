package filterParkingSpot;

import baseTest.BaseTest;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import appItemConstants.MaximumPrice;
import appItemConstants.ParkingDuration;
import appItemConstants.ParkingType;

public class FilterParkingSpotTest extends BaseTest {

    @Test
    public void shouldFilterForParkingSpot() {
        //setting California location
        Location location = new Location(36.7783, -119.4179, 0.0);

        homeScreen.setLocation(location)
                .filterForParkingSpot(MaximumPrice.$7_50, ParkingDuration.Three_Hour_Plus.getHours(), ParkingType.On_Street_Only)
                .park()
                .assertParked();
    }
}