import org.testng.annotations.Test;
import screens.HomeScreen;

public class driveToLocationAndParkTest extends BaseTest {
    @Test
    public void shouldDriveToLocationAndPark() {
        new HomeScreen(driver)
                .init()
                .driveToLocation("Bengaluru");
    }
}