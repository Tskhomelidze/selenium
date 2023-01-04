package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverService {
    private static final Logger LOGGER = LogManager.getLogger(DriverService.class);
    public DriverService() {}
    public WebDriver getDriver(){
        return getDriver(Config.getProperty("browser"));
    }
    public WebDriver getDriver(String browser){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browser);
        desiredCapabilities.setPlatform(Platform.MAC);
        WebDriver driver;
        try {
            driver = new RemoteWebDriver((new URL(Config.getProperty("seleniumURL"))), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            LOGGER.error("Error, could not setup RemoteWebDriver.");
            throw new RuntimeException("Error, could not setup RemoteWebDriver.\n"+e);
        }
        return driver;
    }

}
