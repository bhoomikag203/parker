import org.testng.Assert;
import org.testng.annotations.Test;

public class LookForParkingHistoryTest extends BaseTest {
    @Test
    public void shouldLookForParkingHistory() {

        String actualParkingTime = homeScreen
                .park()
                .getParkingTime();

        driver.navigate().back();
        String expectedParkingTime = parkingHistoryScreen
                .navigateToParkingHistory()
                .getParkingTime();

        Assert.assertEquals(actualParkingTime, expectedParkingTime);
    }

}