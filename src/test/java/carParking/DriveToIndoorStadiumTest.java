package carParking;

import baseTest.BaseTest;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriveToIndoorStadiumTest extends BaseTest {

    @Test
    public void shouldDriveToIndoorStadium() {
        //setting Indoor Stadium location
        Location location = new Location(12.9688, 77.5913, 0.0);

        homeScreen.setLocation(location)
                .park();
        Assert.assertEquals(location.toString(), driver.location().toString());
    }
}