package screens;

import appItemConstants.Menu;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkingHistoryScreen extends BaseScreen {

    @AndroidFindBy(id = "com.streetline.parker:id/timeLbl")
    MobileElement parkingTimeText;

    public ParkingHistoryScreen(AndroidDriver driver) {
        super(driver);
    }

    public ParkingHistoryScreen navigateToParkingHistory() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back();
        new MenuScreen(driver).navigateTo(Menu.PARKING_HISTORY);
        return this;
    }

    public String getParkingTime() {
        System.out.println("expected: " + parkingTimeText.getText().substring(0, 5));
        return parkingTimeText.getText().substring(0, 5);
    }

}