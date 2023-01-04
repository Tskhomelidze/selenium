package service;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotService {
    private static final Logger LOGGER = LogManager.getLogger(ScreenshotService.class);
    private ScreenshotService(){}
    public static void takeScreenshot(WebDriver driver){
        String screenshotFilePath = Config.getProperty("screenshotFilePath");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilePath));
        } catch (IOException e) {
            LOGGER.error("Error, could not take a screenshot.");
            throw new RuntimeException("Error, could not take a screenshot.\n"+e);
        }
    }
}
