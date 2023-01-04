package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;

import java.util.List;

public class PumaPageSearchbar extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(PumaPageSearchbar.class);
    @FindBy(xpath = "//input[@data-test-id='search-box']")
    private WebElement searchBar;
    @FindBy(xpath = "//li[@data-test-id='product-list-item']")
    private List<WebElement> elementsList;

    public PumaPageSearchbar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void search(String searchText){
        type(searchBar,searchText);
        pressKey(searchBar,Keys.ENTER);
    }

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