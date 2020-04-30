import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.ParkingHistoryScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LookForParkingHistoryTest extends BaseTest {
    @Test
    public void shouldLookForParkingHistory() throws ParseException {
        HomeScreen homeScreen = new HomeScreen(driver);

        String actualParkingTime = homeScreen
                .init()
                .park()
                .getParkingTime();
        homeScreen.unPark();

        String parkingTime = new ParkingHistoryScreen(driver)
                .navigateToParkingHistory()
                .getParkingTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date actualTime = simpleDateFormat.parse(actualParkingTime);
        Date expectedTime = simpleDateFormat.parse(parkingTime);
        Assert.assertEquals(actualTime, expectedTime);
    }

}