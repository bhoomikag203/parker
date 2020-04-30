package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ParkingHistoryScreen extends BaseScreen {

    public ParkingHistoryScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ParkingHistoryScreen navigateToParkingHistory(){
        new MenuScreen(driver).navigateTo(Menu.PARKING_HISTORY);
        return this;
    }


}