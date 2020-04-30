import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.ParkingHistoryScreen;

public class LookForParkingHistoryTest extends BaseTest {
    @Test
    public void shouldLookForParkingHistory() {
        new HomeScreen(driver).init();
               /* .park()
                .unPark()
                .setLocation(new Location(13.16, 67.46, 0.0))
                .park()
                .unPark();*/
        new ParkingHistoryScreen(driver)
        .navigateToParkingHistory();
    }

}