package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    protected BasePage basePage;
    protected RemoteWebDriver driver;
    protected String URL;

    public BaseTest() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/configurations.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URL = properties.getProperty("URL");

        String url = "http://localhost:4444";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(properties.getProperty("browser"));
        desiredCapabilities.setPlatform(Platform.MAC);
        try {
            driver = new RemoteWebDriver((new URL(url)), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        basePage = new BasePage(driver);
    }
    @BeforeMethod
    public void openPage(){
        basePage.openPage();
        LOGGER.info("Opened the page: "+URL);
    }
    @AfterMethod
    public void closePage(){
        basePage.quit(5);
        LOGGER.info("Closed the page: "+URL);
    }
    public RemoteWebDriver getDriver(){
        return this.driver;
    }

}
