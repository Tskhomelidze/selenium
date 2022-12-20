package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTests extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(HomePageTests.class);

    // PumaHomePage is not configured like EbayHomePage yet.
//    @Test
//    public void pumaHomePageTest(){
//        PumaHomePage pumaHomePage = new PumaHomePage();
//        pumaHomePage.openPage();
//        pumaHomePage.search("Training shoes");
//        pumaHomePage.printAllItemInfo();
//        pumaHomePage.close();
//    }

    @Test
    public void EbayHomePageTest(){
        EbayHomePage ebayHomePage = new EbayHomePage(getDriver());
        ebayHomePage.clickOnElectronics();
        ebayHomePage.clickOnLaptops();
        ebayHomePage.clickOnAppleLaptops();
    }

    // please ignore this method,
    // it's here just for a testing reason
    @Test
    public void test() throws MalformedURLException {
        WebDriver driver;
        String url = "http://localhost:4444";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.MAC);
        driver = new RemoteWebDriver((new URL(url)), desiredCapabilities);
        driver.get("http://scrolltest.com");
        System.out.println(driver.getCurrentUrl());
    }
}
