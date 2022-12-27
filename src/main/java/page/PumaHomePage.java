package page;

import interfaces.IPageOpened;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;
import service.Config;

import java.util.List;

public class PumaHomePage extends BasePage implements IPageOpened {
    private static final Logger LOGGER = LogManager.getLogger(PumaHomePage.class);
    @FindBy(xpath = "/html/body/div[1]/div/div/nav/div/div[1]/form/div/label/input")
    private WebElement searchBar;
    @FindBy(xpath = "/html/body/div[1]/div/main/div/section/section/ul/li//h3")
    private List<WebElement> elementsList;

    public PumaHomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void search(String searchText){
        type(searchBar,searchText);
        pressKey(searchBar,Keys.ENTER);
    }

    @Override
    public boolean isPageOpened(){
        return super.isPageOpened(searchBar);
    }

    public void printAllItemInfo(){
        LOGGER.info("Elements size = "+elementsList.size());
        for (WebElement webElement : elementsList) {
            LOGGER.info(webElement.getText());
        }
    }

}