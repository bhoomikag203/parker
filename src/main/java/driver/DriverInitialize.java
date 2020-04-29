package driver;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInitialize {
    CapabilityProvider capabilityProvider;
    public AndroidDriver driver;
    public URL appiumURL;
    private int timeout;

    public DriverInitialize() {
        capabilityProvider = new CapabilityProvider();
        try {
            appiumURL = new URL(capabilityProvider.getConfigProperties().getProperty("appiumClient"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        timeout = Integer.parseInt(capabilityProvider.configProperties.getProperty("implicitTimeout"));
    }

    public AndroidDriver initialize() {
        driver = new AndroidDriver<>(appiumURL, capabilityProvider.getMobileCapabilities());
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return driver;
    }
}