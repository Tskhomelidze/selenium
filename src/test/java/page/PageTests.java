package page;

import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseTest;

import static service.DriverService.getDriver;

public class PageTests extends BaseTest {
    @Test
    public void searchBarTest() {
        SearchBar searchBar = new SearchBar(getDriver());
        searchBar.openPage();
        searchBar.search("TRAINING");
        searchBar.printAllItemInfo();
        Assert.assertTrue(searchBar.isPageOpened(), "Error, Page is not opened");
    }

    @Test
    public void hoverTest() {
        Hover hover = new Hover(getDriver("firefox"));
        hover.openPage();
        hover.hoverSportBtn();
        hover.clickShopAllTrainingBtn();
        hover.refresh();
        hover.printAllProducts();
        Assert.assertTrue(hover.isPageOpened(), "Error, Page is not opened");
    }

    @Test
    public void cartTest() {
        Cart cart = new Cart(getDriver("safari"));
        cart.openPage();
        cart.hoverMenBtn();
        cart.clickClassicsBtn();
        cart.refresh();
        cart.clickProduct();
        cart.clickStayOnRegionBtn();
        cart.clickCloseCookiesBannerBtn();
        cart.clickCloseSaleBtn();
        cart.clickSelectSizeL();
        cart.clickAddtoCartBtn();
        Assert.assertTrue(cart.isPageOpened(), "Error, Page is not opened");
    }

}
