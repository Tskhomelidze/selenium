package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected final WebDriver driver;
    private String URL;
    private final String browserName;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        URL = Config.getProperty("websiteURL");
        browserName = Config.getProperty("browser");
    }
    protected void click(WebElement element){
        try{
            scrollToElementIfNotVisible(element);
            element.click();
        }catch (Exception e){
            takeScreenshot();
            LOGGER.error("Error, could not click the WebElement.\n"+element.toString());
            throw new RuntimeException("Error, could not click the WebElement\n"+e);
        }
    }
    protected void hover(WebElement element){
        try{
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }catch (Exception e){
            takeScreenshot();
            LOGGER.error("Error, could not hover the WebElement "+element.toString());
            throw new RuntimeException("Error, could not hover the WebElement.\n"+e);
        }
    }
    protected void type(WebElement element,String text){
        scrollToElementIfNotVisible(element);
        element.sendKeys(text);
    }
    protected void pressKey(WebElement element, Keys key){
        element.sendKeys(key);
    }
    protected void scrollToElementIfNotVisible(WebElement element){
        new Actions(driver).scrollToElement(element).perform();
    }
    public void takeScreenshot(){
        ScreenshotService.takeScreenshot(driver);
    }
    public void refresh(){
        driver.navigate().refresh();
    }
    protected void setPageURL(String URL){
        this.URL = URL;
    }
    protected boolean isPageOpened(WebElement element){
        return element.isDisplayed() || URL.equals(driver.getCurrentUrl());
    }
    public void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
        LOGGER.info("Opened WebSite: "+URL+" in "+browserName);
    }
    public void quit(){
       String driverTitle = driver.getTitle();
       driver.quit();
       LOGGER.info("Quit driver: "+driverTitle);
    }
}
