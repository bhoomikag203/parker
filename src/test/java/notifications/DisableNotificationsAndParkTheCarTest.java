package notifications;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import screens.NotificationsScreen;

public class DisableNotificationsAndParkTheCarTest extends BaseTest {

    @Test
    public void shouldDisableNotificationAndParKCar(){

        new NotificationsScreen(driver)
                .navigateToNotifications()
                .disableNotifications()
                .park()
                .assertParked();
    }
}