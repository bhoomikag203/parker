package driver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.PropertiesReader;

import java.util.Properties;

public class CapabilityProvider {
    private DesiredCapabilities capabilities;
    PropertiesReader propertiesReader;
    Properties configProperties;

    public CapabilityProvider() {
        this.propertiesReader = new PropertiesReader();
    }

    public Properties getConfigProperties() {
        configProperties = this.propertiesReader.getProperties();
        return configProperties;
    }

    public DesiredCapabilities getMobileCapabilities() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configProperties.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configProperties.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.NO_RESET, configProperties.getProperty("noReset"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configProperties.getProperty("appPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configProperties.getProperty("appActivity"));
        capabilities.setCapability(MobileCapabilityType.APP, configProperties.getProperty("app"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configProperties.getProperty("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configProperties.getProperty("automationName"));
        return capabilities;
    }
}