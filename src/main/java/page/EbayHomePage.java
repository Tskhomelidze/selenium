package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;

public class EbayHomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")
    private WebElement electronicsBtn;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/section[3]/div[2]/a[1]")
    private WebElement laptopsBtn;
    @FindBy(xpath = "//*[@id=\"s0-17-12_2-0-1[0]-0-0\"]/ul/li[3]/a")
    private WebElement appleLaptopsBtn;
    public EbayHomePage(RemoteWebDriver driver){
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public void clickOnElectronics(){
        click(electronicsBtn);
    }
    public void clickOnLaptops(){
        click(laptopsBtn);
    }
    public void clickOnAppleLaptops(){
        click(appleLaptopsBtn);
    }
}
