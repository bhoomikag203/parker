import driver.DriverInitialize;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.BaseScreen;

public class BaseTest {

    private DriverInitialize driverInitialize;
    protected AndroidDriver<AndroidElement> driver;

    public BaseTest() {
        driverInitialize = new DriverInitialize();
    }

    @BeforeMethod
    public void setup() {
        driver = driverInitialize.initialize();

    }

    @Test
    public void shouldSayHello() {
        Assert.assertEquals(new BaseScreen(driver).sayHello(), "Helloooo");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}