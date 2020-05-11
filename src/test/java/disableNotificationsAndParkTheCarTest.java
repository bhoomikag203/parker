import org.testng.annotations.Test;
import screens.NotificationsScreen;

public class disableNotificationsAndParkTheCarTest extends BaseTest{

    @Test
    public void shouldDisableNotificationAndParKCar(){

        new NotificationsScreen(driver)
                .navigateToNotifications()
                .disableNotifications()
                .park()
                .assertParked();
    }
}