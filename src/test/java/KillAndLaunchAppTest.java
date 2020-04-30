import org.testng.annotations.Test;
import screens.HomeScreen;

public class KillAndLaunchAppTest extends BaseTest {
    @Test
    public void shouldKillAndRelaunchApp() {
        new HomeScreen(driver)
                .init()
                .park()
                .killApp()
                .assertUnParked();
    }
}