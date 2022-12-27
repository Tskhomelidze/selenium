package page;

import interfaces.IPageOpened;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;

public class NintendoHomePage extends BasePage implements IPageOpened {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/button[1]")
    private WebElement myNintendoStoreBtn;

    @FindBy(xpath = "//*[@id=\"MY_NINTENDO_STORE\"]/div[2]/a[1]")
    private WebElement hardwareBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div[4]/section/div[2]/div[2]/div[1]/div/a")
    private WebElement productBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/section[1]/div/div[3]/div[5]/button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/a")
    private WebElement viewCartBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div[3]/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/button")
    private WebElement removeFromCartBtn;

    @FindBy(xpath = "//*[@id='__next']/main/div[1]/div[1]")
    private WebElement topBar;

    public NintendoHomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened(topBar);
    }

    public void clickMyNintendoStoreBtn(){
        super.click(myNintendoStoreBtn);
    }

    public void clickHardwareBtn(){
        super.click(hardwareBtn);
    }

    public void clickProductBtn() {
        super.click(productBtn);
    }

    public void clickAddToCartBtn(){
        super.click(addToCartBtn);
    }

    public void clickViewCartBtn(){
        super.click(viewCartBtn);
    }

    public void clickRemoveFromCartBtn(){
        super.click(removeFromCartBtn);
    }

}
