package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected final RemoteWebDriver driver;
    private String URL;
    private final String browserName;

    public BasePage(RemoteWebDriver driver) {
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
            throw new RuntimeException("Error, could not click the WebElement\n"+element.toString());
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
    protected void setPageUrl(String URL){
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
       driver.quit();
       LOGGER.info("Closed "+browserName);
    }
}
