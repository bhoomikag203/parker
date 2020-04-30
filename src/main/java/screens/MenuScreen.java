package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuScreen extends BaseScreen {

    @AndroidFindBy(className = "android.widget.ImageButton")
    MobileElement hamburgerIcon;

    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> menuItems;

    public MenuScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void navigateTo(Menu item){
        click(hamburgerIcon);
        for (MobileElement m : menuItems) {
            if (m.getText().equalsIgnoreCase(item.toString())) {
                click(m);
                return ; } }
    }
}