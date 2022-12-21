package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        LOGGER.info("Page opened = "+ ebayHomePage.isPageOpened());
    }

//    @Test
//    public void pumaHomePageTest(){
//        PumaHomePage pumaHomePage = new PumaHomePage(getDriver());
//        pumaHomePage.search("Training boots");
//        pumaHomePage.printAllItemInfo();
//    }
}
