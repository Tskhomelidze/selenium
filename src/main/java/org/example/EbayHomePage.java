package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(EbayHomePage.class);
    @FindBy(css = "#mainContent > div.hl-cat-nav > ul > li:nth-child(3) > a")
    public WebElement electronicsBtn;
    @FindBy(css = "#mainContent > section:nth-child(5) > div.b-visualnav__grid > a:nth-child(1)")
    public WebElement laptopsBtn;
    @FindBy(css = "#s0-17-12_2-0-1\\[0\\]-0-0 > ul > li:nth-child(3) > a")
    public WebElement appleLaptopsBtn;
    public EbayHomePage(RemoteWebDriver driver){
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public void clickOnElectronics(){
        electronicsBtn.click();
    }
    public void clickOnLaptops(){
        new Actions(driver).scrollToElement(laptopsBtn).perform();
        laptopsBtn.click();
    }
    public void clickOnAppleLaptops(){
        appleLaptopsBtn.click();
    }
}
