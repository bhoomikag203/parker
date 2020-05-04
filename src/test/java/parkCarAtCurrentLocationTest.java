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

}