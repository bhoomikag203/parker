package baseTest;

import driver.DriverInitialize;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;
import screens.BaseScreen;
import screens.HomeScreen;
import screens.ParkingHistoryScreen;
import utility.ScreenshotHelper;

public class BaseTest {

    private DriverInitialize driverInitialize;
    protected AndroidDriver<AndroidElement> driver;
    protected HomeScreen homeScreen;
    protected ParkingHistoryScreen parkingHistoryScreen;

    public BaseTest() {
        driverInitialize = new DriverInitialize();
    }

    @BeforeMethod
    public void setup() {
        driver = driverInitialize.initialize();
        homeScreen = new BaseScreen(driver).init();
        parkingHistoryScreen = new ParkingHistoryScreen(driver);
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (TestResult.FAILURE == result.getStatus()) {
            new ScreenshotHelper().getScreenshot(driver);
        }
        driver.quit();
    }
}