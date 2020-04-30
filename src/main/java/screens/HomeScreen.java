package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @AndroidFindBy(id = "com.streetline.parker:id/maps_router_time")
    MobileElement estimatedTimeText;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_onboarding_pager_next")
    MobileElement nextButton;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomeScreen init(){
        driver.findElementByAndroidUIAutomator("text(\"ENABLE LOCATION\")").click();
        driver.findElementByAndroidUIAutomator("text(\"ALLOW ONLY WHILE USING THE APP\")").click();
        click(nextButton);
        click(nextButton);
        click(nextButton);
        return this;
    }

    public HomeScreen setLocation(Location location){
        System.out.println("before "+ driver.location());
        driver.setLocation(location);
        System.out.println("after "+ driver.location());
        return this;
    }

    public HomeScreen park() {
        click(parkVehicleButton);
        click(setParkingLocationButton);
        System.out.println("Park"+ driver.location());
        return this;
    }

    public void assertParked(){
        String message = parkedAtMessage.getText();
        Assert.assertTrue(message.contains("Parked at"));
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

    public HomeScreen unPark() {
        click(dismissParkLocationButton);
        return this;
    }
}