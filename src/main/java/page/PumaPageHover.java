package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;

import java.util.List;

public class PumaPageHover extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(PumaPageHover.class);
    @FindBy(xpath = "//input[@data-test-id='search-box']")
    private WebElement searchBar;

    @FindBy(xpath = "//a[@data-link-name='Gift Guide']")
    private WebElement giftGuide;
    @FindBy(xpath = "//ul/li/a[@role='menuitem' and  @data-link-name='Shoes $49.99 & Under']")
    private WebElement shoesBtn;

    @FindBy(xpath = "//li[@data-test-id='product-list-item']")
    private List<WebElement> productList;
    public PumaPageHover(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void hoverGiftGuide(){
        hover(giftGuide);
    }
    public void clickShoesBtn(){
        click(shoesBtn);
    }
    public void printAllProducts(){

        LOGGER.info("Product number = "+productList.size());
        for (WebElement element : productList)
            System.out.println(element.getText());
    }

    public boolean isPageOpened(){
        return super.isPageOpened(searchBar);
    }

}
