package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.BasePage;

import java.time.Duration;

public class PumaPageCart extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(PumaPageCart.class);

    @FindBy(xpath = "//li[@data-test-id='main-nav-category-item']//span[text()='Men']")
    WebElement menBtn;

    @FindBy(xpath = "//li[@data-test-id='main-nav-category-item']//ul[@aria-label='Clothing']//a[@data-link-name='Classics']")
    WebElement classicsBtn;

    @FindBy(xpath = "//a[@data-test-id='product-list-item-link' and @aria-label=\"Go to Classics Logo Men's Tee Peacoat\"]")
    WebElement product;

    @FindBy(xpath = "//span[@data-content='size-value' and text() = 'L']")
    WebElement selectSizeL;

    @FindBy(xpath = "//button[@data-test-id='stay-on-region-button']")
    WebElement stayOnRegionBtn;

    @FindBy(xpath = "//button[@data-test-id='cookie-banner-close-btn']")
    WebElement closeCookiesBannerBtn;

    @FindBy(xpath = "//button[@data-test-id='newsletter-sign-up-form-button']/div")
    WebElement closeSaleBtn;
    @FindBy(xpath = "//button[@data-test-id='pdp-add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@data-test-id='minicart-cart-link']")
    WebElement viewCartBtn;

    @FindBy(xpath = "//button[@data-test-id='remove-product-button']")
    WebElement removeFromCart;

    @FindBy(xpath = "//button[@id='confirm-button']")
    WebElement removeConfirmBtn;

    @FindBy(xpath = "//input[@data-test-id='search-box']")
    private WebElement searchBar;

    public PumaPageCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void hoverMenBtn(){
        hover(menBtn);
    }

    public void clickClassicsBtn(){
        click(classicsBtn);
    }

    public void clickProduct(){
        WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
        click(product);
    }

    public void clickSelectSizeL(){
        click(selectSizeL);
    }

    public void clickStayOnRegionBtn(){
        click(stayOnRegionBtn);
    }

    public void clickCloseCookiesBannerBtn(){
        click(closeCookiesBannerBtn);
    }

    public void clickCloseSaleBtn(){
        WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(closeSaleBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
        click(closeSaleBtn);
    }

    public void clickAddtoCartBtn(){
        click(addToCartBtn);
    }

    public void clickViewCartBtn(){
        click(viewCartBtn);
    }

    public void clickRemoveFromCartBtn(){
        click(removeFromCart);
    }

    public void clickRemoveConfirmBtn(){
        click(removeConfirmBtn);
    }

    public boolean isPageOpened(){
        return super.isPageOpened(searchBar);
    }

}
