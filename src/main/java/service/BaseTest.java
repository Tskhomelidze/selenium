package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;

import static service.DriverService.getDriver;
import static service.DriverService.removeDriver;

public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @AfterMethod
    public void quit() {
        long currentThreadId = Thread.currentThread().getId();
        getDriver().quit();
        removeDriver(currentThreadId);
        LOGGER.info("Quit the driver with id: " + currentThreadId);
    }
}
