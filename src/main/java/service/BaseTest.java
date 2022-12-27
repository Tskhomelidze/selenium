package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    private final BasePage basePage;
    private final RemoteWebDriver driver;
    public BaseTest() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Config.getProperty("browser"));
        desiredCapabilities.setPlatform(Platform.MAC);
        try {
            driver = new RemoteWebDriver((new URL(Config.getProperty("seleniumURL"))), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            LOGGER.error("Error, could not setup RemoteWebDriver.");
            throw new RuntimeException(e);
        }
        basePage = new BasePage(driver);
    }
    public RemoteWebDriver getDriver(){
        return this.driver;
    }
    @BeforeMethod
    public void openPage(){
        basePage.openPage();
    }
    @AfterMethod
    public void closePage(){
        basePage.quit();
    }

}
