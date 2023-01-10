package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form extends BasePage {

    @FindBy(xpath = "//a[@role='menuitem' and text()='Purchase a Digital Gift Card']")
    WebElement digitalGiftBtn;

    @FindBy(xpath = "//div[text()='Stay on United States']")
    WebElement stayOnUSBtn;

    @FindBy(xpath = "//button[@data-test-id='cookie-banner-close-btn']")
    WebElement closeCookiesBannerBtn;

    @FindBy(xpath = "//button[@data-test-id='newsletter-sign-up-form-button']/div")
    WebElement closeSaleBtn;

    @FindBy(xpath = "//select[@id='select-gift-card-value']/option[@value='50']")
    WebElement selectGiftCardBtn;

    @FindBy(xpath = "//*[text() = '$50.00']")
    WebElement giftCard;

    @FindBy(xpath = "//input[@id='recipientName']")
    WebElement recipientName;

    @FindBy(xpath = "//input[@id='yourName']")
    WebElement yourName;
    @FindBy(xpath = "//input[@id='recipientEmail']")
    WebElement recipientEmail;
    @FindBy(xpath = "//input[@id='confirmEmail']")
    WebElement confirmEmail;
    @FindBy(xpath = "//textarea[@id='giftMessage']")
    WebElement giftMessage;

    @FindBy(xpath = "//button[@data-test-id='gift-card-add-to-cart']")
    WebElement addToCartBtn;

    public Form(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void clickStayOnUSBtn() {
        click(stayOnUSBtn);
    }

    public void clickCloseCookiesBannerBtn() {
        click(closeCookiesBannerBtn);
    }

    public void clickCloseSaleBtn(){
        click(closeSaleBtn);
    }

    public void clickDigitalGiftBtn() {
        click(digitalGiftBtn);
    }

    public void selectGiftCard() {
        click(selectGiftCardBtn);
    }

    public void ClickGiftCard() {
        click(giftCard);
    }

    public void typeRecipientName(String text) {
        type(recipientName, text);
    }

    public void typeYourName(String text) {
        type(yourName, text);
    }

    public void typeRecipientEmail(String text) {
        type(recipientEmail, text);
        type(confirmEmail, text);
    }

    public void typeGiftMessage(String message) {
        type(giftMessage, message);
    }

    public void clickAddToCartBtn() {
        click(addToCartBtn);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(addToCartBtn);
    }

}
