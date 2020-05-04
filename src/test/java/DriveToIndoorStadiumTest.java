import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class DriveToIndoorStadiumTest extends BaseTest {
    @Test
    public void shouldDriveToIndoorStadium() {
        //setting Indoor Stadium location
        Location location = new Location(12.9688, 77.5913, 0.0);

        new HomeScreen(driver)
                .init()
                .setLocation(location)
                .park();
        Assert.assertEquals(location.toString(), driver.location().toString());
    }
}