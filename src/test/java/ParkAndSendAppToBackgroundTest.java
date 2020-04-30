import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class ParkAndSendAppToBackgroundTest extends BaseTest {
    @Test
    public void shouldParkCarAndSendAppToBackground(){
        new HomeScreen(driver)
                .init()
                .park()
                .sendAppToBackground()
                .unPark()
                .assertUnParked();
    }
}