package screens;

import appItemConstants.Menu;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class MenuScreen extends BaseScreen {
    @AndroidFindBy(className = "android.widget.ImageButton")
    MobileElement hamburgerIcon;

    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> menuItems;

    public MenuScreen(AndroidDriver driver) {
        super(driver);
    }

    public void navigateTo(Menu item){
        waitForElementToBeVisible(hamburgerIcon);
        click(hamburgerIcon);
        for (MobileElement m : menuItems) {
            if (m.getText().equalsIgnoreCase(item.toString().replaceAll("_"," "))) {
                m.click();
                return ; } }
    }
}