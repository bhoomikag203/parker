import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ParkingHistoryScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LookForParkingHistoryTest extends BaseTest {
    @Test
    public void shouldLookForParkingHistory() {

        String actualParkingTime = homeScreen
                .park()
                .getParkingTime();

        homeScreen.unPark();

        String expectedParkingTime = new ParkingHistoryScreen(driver)
                .navigateToParkingHistory()
                .getParkingTime();

        Assert.assertEquals(actualParkingTime, expectedParkingTime);
    }

}