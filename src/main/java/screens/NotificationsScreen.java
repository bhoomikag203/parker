package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotificationsScreen extends BaseScreen {

    @AndroidFindBy(id = "android:id/switch_widget")
    List<MobileElement> notificationList;

    public NotificationsScreen(AndroidDriver driver) {
        super(driver);
    }

    public NotificationsScreen navigateToNotifications(){
        new MenuScreen(driver).navigateTo(Menu.NOTIFICATIONS);
        return this;
    }

    public HomeScreen disableNotifications(){
        for(MobileElement notification: notificationList){
            click(notification);
        }
        driver.navigate().back();
        return new HomeScreen(driver);
    }


}