package page;

import interfaces.IPageOpened;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.BasePage;
import service.Config;

public class EbayHomePage extends BasePage implements IPageOpened {
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")
    private WebElement electronicsBtn;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/section[3]/div[2]/a[1]")
    private WebElement laptopsBtn;
    @FindBy(xpath = "//*[@id=\"s0-17-12_2-0-1[0]-0-0\"]/ul/li[3]/a")
    private WebElement appleLaptopsBtn;
    @FindBy(xpath = "//*[@id=\"gh-btn\"]")
    private WebElement searchBtn;
    public EbayHomePage(RemoteWebDriver driver){
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public void clickOnElectronics(){
        super.click(electronicsBtn);
    }
    public void clickOnLaptops(){
        super.click(laptopsBtn);
    }
    public void clickOnAppleLaptops(){
        super.click(appleLaptopsBtn);
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened(searchBtn);
    }

}
