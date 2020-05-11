package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseScreen {

    protected AndroidDriver driver;
    protected WebDriverWait webDriverWait;

    @AndroidFindBy(id = "com.streetline.parker:id/maps_onboarding_pager_next")
    MobileElement nextButton;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        webDriverWait = new WebDriverWait(driver, 60);
    }

    public HomeScreen init() {
        driver.findElementByAndroidUIAutomator("text(\"ENABLE LOCATION\")").click();
        driver.findElementByAndroidUIAutomator("text(\"ALLOW ONLY WHILE USING THE APP\")").click();
        click(nextButton);
        click(nextButton);
        click(nextButton);
        return new HomeScreen(driver);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String keysToSend) {
        waitForElementToBeVisible(element);
        element.sendKeys(keysToSend);
    }

    protected void waitForElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementsToBeVisible(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public String sayHello() {
        return "Helloooo";
    }
}