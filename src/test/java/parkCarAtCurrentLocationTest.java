import entities.Vehicle;
import entities.VehicleBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class parkCarAtCurrentLocationTest extends BaseTest {
    @Test
    public void shouldParkCarAtCurrentLocation() {
        new HomeScreen(driver)
                .park()
                .assertParked();
    }
}