package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Language extends BasePage {
    @FindBy(xpath = "//button[@id='account-button']")
    WebElement accountBtn;

    @FindBy(xpath = "//li[@class='py-2']")
    WebElement languageBtn;

    @FindBy(xpath = "//input[@id='locale-search-input']")
    WebElement languageSearchBar;
    @FindBy(xpath = "//a[@hreflang='es-es']")
    WebElement spanishBtn;

    @FindBy(xpath = "//a[@data-js-change-locale]")
    WebElement languageBtnOnSpanishPage;

    @FindBy(xpath = "//a[@data-locale='en_US']")
    WebElement englishLangBtn;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookiesBtn;

    @FindBy(xpath = "//div[@id='wps-overlay-close-button']")
    WebElement closeSaleBtn;

    public Language(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public void clickAccountBtn() {
        click(accountBtn);
    }

    public void clickLanguageBtn() {
        click(languageBtn);
    }

    public void clickLanguageBtnOnSpanishPage() {
        click(languageBtnOnSpanishPage);
    }

    public void clickSpainBtn() {
        click(spanishBtn);
    }

    public void clickEnglishLangBtn() {
        click(englishLangBtn);
    }

    public void searchEnglishLanguage() {
        type(languageSearchBar, "United States");
    }


    public void clickAcceptCookiesBtn() {
        click(acceptCookiesBtn);
    }

    public void clickCloseSaleBtn() {
        click(closeSaleBtn);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(accountBtn);
    }
}