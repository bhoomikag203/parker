package appActions;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KillAndLaunchAppTest extends BaseTest {

    @Test
    public void shouldKillAndRelaunchApp() {

        boolean parked = homeScreen
                .park()
                .killApp()
                .isParked();
        Assert.assertTrue(parked);
    }
}