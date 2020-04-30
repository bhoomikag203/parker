import org.testng.annotations.Test;
import screens.Menu;
import screens.MenuScreen;
import screens.NotificationsScreen;

public class disableNotificationsAndParkTheCarTest extends BaseTest{
    @Test
    public void shouldDisableNotificationAndParKCar(){
        new NotificationsScreen(driver)
                .navigateToNotification()
                .disableNotifications()
                .park()
                .assertParked();
    }
}