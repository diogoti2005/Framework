package com.demoqa.shop.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Browser {
    static Logger log = LoggerFactory.getLogger(Browser.class);

    private static WebDriver instance;

    private static WebDriver createBrowser() {

        String browserName = PropertyReader.getBrowserName();
        WebDriver driver = null;

        switch (browserName.toLowerCase()) {
            case "firefox": {
                System.setProperty("webdriver.gecko.driver",
                        "src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            break;
            case "chrome": {
                System.setProperty("webdriver.chrome.driver",
                        "src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            break;
        }
        log.info("New {} browser session has been started", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(PropertyReader.getWait(), TimeUnit.SECONDS);
        driver.get(PropertyReader.getBaseUrl());
        return driver;
    }

    public static WebDriver getBrowser() {
        if (instance == null) {
            instance = createBrowser();
        }
        return instance;
    }

    public static void closeBrowser() {
        if (instance != null) {
            instance.close();
            instance.quit();
            instance = null;
            log.info("'Browser' has been closed");
        } else {
            log.info("There is no 'Browser' to be closed");
        }
    }
}