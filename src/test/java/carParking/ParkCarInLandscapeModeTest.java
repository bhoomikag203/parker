package carParking;

import baseTest.BaseTest;
import org.testng.annotations.Test;

public class ParkCarInLandscapeModeTest extends BaseTest {

    @Test
    public void shouldCheckIfCarIsParkedInLandscapeMode() {

        homeScreen.setLandscapeMode()
                .park()
                .assertParkedInLandscapeMode();
    }
}