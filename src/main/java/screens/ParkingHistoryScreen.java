package screens;

import appItemConstants.Menu;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

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
        String expectedTime = parkingTimeText.getText().substring(0, 5);
        System.out.println("expected: " + expectedTime);
        if(expectedTime.contains("P") || expectedTime.contains("A")){
            expectedTime = "0" + expectedTime;
        }
        return expectedTime.substring(0, 5);
    }

}