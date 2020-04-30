import entities.Vehicle;
import entities.VehicleBuilder;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class parkCarAtCurrentLocationTest extends BaseTest {
    @Test
    public void shouldParkCarAtCurrentLocation() {
        new HomeScreen(driver)
                .init()
                .park()
                .assertParked();
    }

    @Test
    public void shouldSetLocation(){
        //set location to California
        Location location = new Location(36.7783, 119.4179,0.0);

        new HomeScreen(driver)
                .init()
                .setLocation(location);
    }

}