import org.testng.annotations.Test;
import screens.HomeScreen;

public class ParkCarInLandscapeModeTest extends BaseTest {

    @Test
    public void shouldCheckIfCarIsParkedInLandscapeMode(){
        new HomeScreen(driver)
                .init()
                .setLandscapeMode()
                .park()
                .assertParkedInLandscapeMode();
    }
}