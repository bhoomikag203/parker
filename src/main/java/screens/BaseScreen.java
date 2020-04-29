package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    protected AndroidDriver driver;
    private WebDriverWait webDriverWait;



    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        driver.findElementByAndroidUIAutomator("text(\"ENABLE LOCATION\")").click();
        driver.findElementByAndroidUIAutomator("text(\"ALLOW ONLY WHILE USING THE APP\")").click();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.streetline.parker:id/maps_onboarding_pager_next\")").click();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.streetline.parker:id/maps_onboarding_pager_next\")").click();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.streetline.parker:id/maps_onboarding_pager_next\")").click();
    }


    public String sayHello(){
        return "Helloooo";
    }
}