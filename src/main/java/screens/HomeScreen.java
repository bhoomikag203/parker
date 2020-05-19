package screens;

import appItemConstants.MaximumPrice;
import appItemConstants.ParkingType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomeScreen extends BaseScreen {


    @AndroidFindBy(id = "com.streetline.parker:id/maps_fab_park_button")
    MobileElement parkVehicleButton;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_park_banner_label")
    MobileElement setParkingLocationButton;

    @AndroidFindBy(id = "com.streetline.parker:id/dismiss_park_location_button")
    MobileElement dismissParkLocationButton;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_toolbar_autocomplete")
    MobileElement searchParkerTextBox;

    @AndroidFindBy(id = "com.streetline.parker:id/youParkedAtTxt")
    MobileElement parkedAtMessage;

    @AndroidFindBy(id = "com.streetline.parker:id/list_item_search_title")
    List<MobileElement> locationSearchResultList;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_search_result_fab")
    MobileElement directionButton;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_launch_route_text")
    MobileElement startRouteButton;


    @AndroidFindBy(id = "com.streetline.parker:id/maps_toolbar_filter")
    MobileElement filterButton;

    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> filterParkingSpot;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    private boolean isParked;

    public HomeScreen setLocation(Location location) {
        try {
            System.out.println("before " + driver.location());
            driver.setLocation(location);
            Thread.sleep(10000);
            System.out.println("after " + driver.location());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomeScreen park() {
        click(parkVehicleButton);
        click(setParkingLocationButton);
        System.out.println("Park" + driver.location());
        isParked = true;
        return this;
    }

    public void assertParked() {
        String message = parkedAtMessage.getText();
        Assert.assertTrue(message.contains("Parked at"));
    }

    public String getParkingTime() {
        System.out.println("actual :"+ parkedAtMessage.getText().split("\\s")[2]);
        return parkedAtMessage.getText().split("\\s")[2];

    }

    public HomeScreen driveToLocation(String location) {
        try {
            click(searchParkerTextBox);
            sendKeys(searchParkerTextBox, location);
            click(locationSearchResultList.get(0));
            click(directionButton);
            Thread.sleep(6000);
            click(startRouteButton);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomeScreen setLandscapeMode() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        return this;
    }

    public HomeScreen sendAppToBackground() {
        driver.runAppInBackground(Duration.ofSeconds(10));
        return this;
    }

    public HomeScreen killApp() {
        driver.resetApp();
        return this;
    }

    public HomeScreen unPark() {
        waitForElementToBeVisible(dismissParkLocationButton);
        if (isParked == true) {
            click(dismissParkLocationButton);
            return this;
        } else {
            System.out.println("Car not parked!!!");
        }
        return this;
    }

    public boolean isParked() {
        return isParked;
    }

    public HomeScreen filterForParkingSpot(MaximumPrice price, String duration, ParkingType type) {

        click(filterButton);

        for (MobileElement w :
                filterParkingSpot) {
            if (w.getText().equalsIgnoreCase(String.valueOf(price).replace("_", ".")))
                click(w);
            if (w.getText().equalsIgnoreCase(String.valueOf(duration)))
                click(w);
            if (w.getText().equalsIgnoreCase(String.valueOf(type).replace("_", " ")))
                click(w);
        }

        driver.navigate().back();

        return this;
    }

    public void assertUnParked() {
        Assert.assertTrue(parkVehicleButton.isDisplayed());
    }

    public void assertParkedInLandscapeMode() {
        Assert.assertTrue(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE));
    }

}