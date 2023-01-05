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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverService {
    private static final Logger LOGGER = LogManager.getLogger(DriverService.class);
    private static final Map<Long, WebDriver> webDriverHashMap = new ConcurrentHashMap<>();

    public DriverService() {
    }

    public static WebDriver getDriver() {
        return getDriver(Config.getProperty("browser"));
    }

    public static WebDriver getDriver(String browser) {
        Long currentThreadId = Thread.currentThread().getId();
        if (!webDriverHashMap.containsKey(currentThreadId)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(browser);
            desiredCapabilities.setPlatform(Platform.MAC);
            try {
                WebDriver driver = new RemoteWebDriver(new URL(Config.getProperty("seleniumURL")), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                webDriverHashMap.put(currentThreadId, driver);
                LOGGER.info("added new driver with id = " + currentThreadId + " inside driver pool.");
            } catch (MalformedURLException e) {
                LOGGER.error("Error, could not setup RemoteWebDriver.");
                throw new RuntimeException("Error, could not setup RemoteWebDriver.\n" + e);
            }
        }
        return webDriverHashMap.get(currentThreadId);
    }

    public static void removeDriver(Long id) {
        webDriverHashMap.remove(id);
    }

}
