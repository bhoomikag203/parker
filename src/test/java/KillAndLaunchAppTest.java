import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;

public class KillAndLaunchAppTest extends BaseTest {

    @Test
    public void shouldKillAndRelaunchApp() {
        boolean parked = new HomeScreen(driver)
                .init()
                .park()
                .killApp()
                .isParked();
        Assert.assertTrue(parked);
    }
}