package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseTest;

public class HomePageTests extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTests.class);
    @Test
    public void ebayHomePageTest(){
        EbayHomePage ebayHomePage = new EbayHomePage(getDriver());
        ebayHomePage.clickOnElectronics();
        ebayHomePage.clickOnLaptops();
        ebayHomePage.clickOnAppleLaptops();
        Assert.assertTrue(ebayHomePage.isPageOpened(),"Error, page is not opened.");
    }

    @Test
    public void pumaHomePageTest(){
        PumaHomePage pumaHomePage = new PumaHomePage(getDriver());
        pumaHomePage.search("TRAINING");
        pumaHomePage.printAllItemInfo();
        Assert.assertTrue(pumaHomePage.isPageOpened(),"Error, Page is not opened"); ;
    }

    @Test
    public void nintendoHomePageTest(){
        NintendoHomePage nintendoHomePage = new NintendoHomePage(getDriver());
        nintendoHomePage.clickMyNintendoStoreBtn();
        nintendoHomePage.clickHardwareBtn();
        nintendoHomePage.clickProductBtn();
        nintendoHomePage.clickAddToCartBtn();
        nintendoHomePage.clickViewCartBtn();
        nintendoHomePage.clickRemoveFromCartBtn();
        Assert.assertTrue(nintendoHomePage.isPageOpened(),"Error, Page is not opened"); ;
    }

}
