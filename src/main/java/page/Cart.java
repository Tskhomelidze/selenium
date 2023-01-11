package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cart extends BasePage {
    @FindBy(xpath = "//li[@data-test-id='main-nav-category-item']//span[text()='Men']")
    WebElement menBtn;

    @FindBy(xpath = "//li[@data-test-id='main-nav-category-item']//ul[@aria-label='Clothing']//a[@data-link-name='Classics']")
    WebElement classicsBtn;

    @FindBy(xpath = "//a[@data-test-id='product-list-item-link']")
    List<WebElement> product;

    @FindBy(xpath = "//div[@aria-label=\"Select Size\"]//span[text()='L']")
    WebElement selectSizeL;

    @FindBy(xpath = "//button[@data-test-id='stay-on-region-button']")
    WebElement stayOnRegionBtn;

    @FindBy(xpath = "//button[@data-test-id='cookie-banner-close-btn']")
    WebElement closeCookiesBannerBtn;

    @FindBy(xpath = "//button[@data-test-id='newsletter-sign-up-form-button']/div")
    WebElement closeSaleBtn;
    @FindBy(xpath = "//button[@data-test-id='pdp-add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//input[@data-test-id='search-box']")
    private WebElement searchBar;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void hoverMenBtn() {
        hover(menBtn);
    }

    public void clickClassicsBtn() {
        click(classicsBtn);
    }

    public void clickProduct() {
        click(product.get(0));
    }

    public void clickSelectSizeL() {
        click(selectSizeL);
    }

    public void clickStayOnRegionBtn() {
        click(stayOnRegionBtn);
    }

    public void clickCloseCookiesBannerBtn() {
        click(closeCookiesBannerBtn);
    }

    public void clickCloseSaleBtn() {
        click(closeSaleBtn);
    }

    public void clickAddtoCartBtn() {
        click(addToCartBtn);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(searchBar);
    }

}
