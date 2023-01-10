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
        Hover hover = new Hover(getDriver());
        hover.openPage();
        hover.hoverSportBtn();
        hover.clickShopAllTrainingBtn();
        hover.refresh();
        hover.printAllProducts();
        Assert.assertTrue(hover.isPageOpened(), "Error, Page is not opened");
    }

    @Test
    public void cartTest() {
        Cart cart = new Cart(getDriver());
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

    @Test
    public void formTest() {
        Form form = new Form(getDriver());
        form.openPage();
        form.clickStayOnUSBtn();
        form.clickCloseCookiesBannerBtn();
        form.clickCloseSaleBtn();
        form.clickDigitalGiftBtn();
        form.selectGiftCard();
        form.typeYourName("My Fake Name");
        form.typeRecipientName("Recipient Fake Name");
        form.typeRecipientEmail("FakeEmail@gmail.com");
        form.typeGiftMessage("A gift from Solvd.");
        form.clickAddToCartBtn();
        Assert.assertTrue(form.isPageOpened(), "Error, Page is not opened");
    }

    @Test
    public void languageTest() {
        Language language = new Language(getDriver());
        language.openPage();
        language.clickAccountBtn();
        language.clickLanguageBtn();
        language.clickSpainBtn();
        language.clickAcceptCookiesBtn();
        language.clickCloseSaleBtn();
        language.clickLanguageBtnOnSpanishPage();
        language.searchEnglishLanguage();
        language.clickEnglishLangBtn();
        Assert.assertTrue(language.isPageOpened(), "Error, Page is not opened");
    }

}
