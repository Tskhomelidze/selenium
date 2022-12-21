package service;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected final RemoteWebDriver driver;
    protected final String URL;
    protected final String browserName;
    protected final String screenshotFilePath;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        final Properties properties = Configurations.getProperties();
        URL = properties.getProperty("websiteURL");
        browserName = properties.getProperty("browser");
        screenshotFilePath = properties.getProperty("screenshotFilePath");
    }
    public boolean isPageOpened(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState")
                .toString().equals("complete");
    }
    public void click(WebElement element){
        try{
            scrollToElementIfNotVisible(element);
            element.click();
        }catch (Exception e){
            takeScreenshot();
            LOGGER.error("Error, could not click the WebElement "+element.toString());
            throw new RuntimeException(e);
        }
    }
    public void type(WebElement element,String text){
        scrollToElementIfNotVisible(element);
        element.sendKeys(text);
    }
    public void pressKey(WebElement element, Keys key){
        element.sendKeys(key);
    }

    public void scrollToElementIfNotVisible(WebElement element){
        if(!element.isDisplayed())
            new Actions(driver).scrollToElement(element).perform();
    }
    public void takeScreenshot(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilePath));
        } catch (IOException e) {
            LOGGER.error("Error, could not take a screenshot.");
            throw new RuntimeException(e);
        }
    }
    public void waitForLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> (isPageOpened()));
    }
    public void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
        LOGGER.info("Opened WebSite: "+URL+" in "+browserName);
    }
    public void quit(){
       driver.quit();
       LOGGER.info("Closed "+browserName);
    }
}
