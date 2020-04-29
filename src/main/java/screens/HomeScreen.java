package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {


    @AndroidFindBy(id = "com.streetline.parker:id/maps_fab_park_button")
    MobileElement parkVehicleButton;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_park_banner_label")
    MobileElement setParkingLocationButton;

    @AndroidFindBy(id = "com.streetline.parker:id/dismiss_park_location_button")
    MobileElement dismissParkLocationButton;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_toolbar_autocomplete")
    MobileElement searchParkerTextBox;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_set_park_container")
    MobileElement mapContainer;

    @AndroidFindBy(id = "com.streetline.parker:id/youParkedAtTxt")
    MobileElement parkedAtMessage;


//    Location location = driver.location();

    public HomeScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomeScreen park() {
        click(parkVehicleButton);
        click(setParkingLocationButton);
        return this;
    }

    public void assertParked(){
        String message = parkedAtMessage.getText();
        Assert.assertTrue(message.contains("Parked at"));
    }

    public void unPark() {
        click(dismissParkLocationButton);
    }
}