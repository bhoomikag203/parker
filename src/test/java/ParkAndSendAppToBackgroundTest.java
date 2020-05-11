import org.testng.annotations.Test;

public class ParkAndSendAppToBackgroundTest extends BaseTest {

    @Test
    public void shouldParkCarAndSendAppToBackground() {

        homeScreen.park()
                .sendAppToBackground()
                .unPark()
                .assertUnParked();
    }
}