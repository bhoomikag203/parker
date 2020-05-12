import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LookForParkingHistoryTest extends BaseTest {
    @Test
    public void shouldLookForParkingHistory() {

        String actualParkingTime = homeScreen
                .park()
                .getParkingTime();

        new WebDriverWait(driver, 3000);
        String expectedParkingTime = parkingHistoryScreen
                .navigateToParkingHistory()
                .getParkingTime();

        Assert.assertEquals(actualParkingTime, expectedParkingTime);
    }

}