import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.Menu;
import screens.MenuScreen;
import screens.NotificationsScreen;

public class disableNotificationsAndParkTheCarTest extends BaseTest{
    @Test
    public void shouldDisableNotificationAndParKCar(){
        new HomeScreen(driver).init();
        new NotificationsScreen(driver)
                .navigateToNotification()
                .disableNotifications()
                .park()
                .assertParked();
    }
}