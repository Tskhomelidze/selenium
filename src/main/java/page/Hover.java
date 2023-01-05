package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Hover extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(Hover.class);
    @FindBy(xpath = "//input[@data-test-id='search-box']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[text() = 'Sport']")
    private WebElement sportBtn;
    @FindBy(xpath = "//a[@data-link-name = 'Shop All Training']")
    private WebElement shopAllTrainingBtn;

    @FindBy(xpath = "//li[@data-test-id='product-list-item']")
    private List<WebElement> productList;

    public Hover(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void hoverSportBtn() {
        hover(sportBtn);
    }

    public void clickShopAllTrainingBtn() {
        click(shopAllTrainingBtn);
    }

    public void printAllProducts() {
        LOGGER.info("Product number = " + productList.size());
        for (WebElement element : productList)
            System.out.println(element.getText());
    }

    public boolean isPageOpened() {
        return super.isPageOpened(searchBar);
    }

}
