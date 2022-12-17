package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class PumaHomePageTest {
    private static final Logger LOGGER = LogManager.getLogger(PumaHomePageTest.class);
    @Test
    public void testPage(){
        PumaHomePage pumaHomePage = new PumaHomePage();
        pumaHomePage.openPage();
        pumaHomePage.search("Training shoes");
        pumaHomePage.printAllItemInfo();
        pumaHomePage.close();
    }


}
