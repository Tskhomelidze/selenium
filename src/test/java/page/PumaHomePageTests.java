package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.DriverService;
public class PumaHomePageTests extends DriverService {
    private static final Logger LOGGER = LogManager.getLogger(PumaHomePageTests.class);

    @Test
    public void pumaSearchBarPageTest() {
        PumaPageSearchbar pumaHomePage = new PumaPageSearchbar(getDriver("firefox"));
        pumaHomePage.openPage();
        pumaHomePage.search("TRAINING");
        pumaHomePage.printAllItemInfo();
        Assert.assertTrue(pumaHomePage.isPageOpened(), "Error, Page is not opened");
        pumaHomePage.quit();
    }

    @Test
    public void pumaHoverPageTest() {
        PumaPageHover pumaHoverPage = new PumaPageHover(getDriver());
        pumaHoverPage.openPage();
        pumaHoverPage.hoverGiftGuide();
        pumaHoverPage.clickShoesBtn();
        pumaHoverPage.refresh(); // without refreshing the product list is empty
        pumaHoverPage.printAllProducts();
        Assert.assertTrue(pumaHoverPage.isPageOpened(), "Error, Page is not opened");
        pumaHoverPage.quit();
    }

    @Test
    public void PumaPageCartTest() {
        PumaPageCart pumaPageCart = new PumaPageCart(getDriver());
        pumaPageCart.openPage();
        pumaPageCart.hoverMenBtn();
        pumaPageCart.clickClassicsBtn();
        pumaPageCart.refresh();
        pumaPageCart.clickProduct();
        pumaPageCart.clickStayOnRegionBtn();
        pumaPageCart.clickCloseCookiesBannerBtn();
        pumaPageCart.clickCloseSaleBtn();
        pumaPageCart.clickSelectSizeL();
        pumaPageCart.clickAddtoCartBtn();
        pumaPageCart.clickViewCartBtn();
        pumaPageCart.clickRemoveFromCartBtn();
        pumaPageCart.clickRemoveConfirmBtn();
        Assert.assertTrue(pumaPageCart.isPageOpened(),"Error, Page is not opened");
    }

}
