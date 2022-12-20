package org.example;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    protected final RemoteWebDriver driver;
    protected final String URL;
    protected final String browserName;

    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/configurations.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URL = properties.getProperty("URL");
        browserName = properties.getProperty("browser");
    }
    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }
    void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
    }
    void quit(long closeTimeInSeconds){
        new Actions(driver).pause(closeTimeInSeconds*1000).perform();
        driver.quit();
    }
    void quit(){
       driver.quit();
    }
}
