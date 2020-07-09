package com.demoqa.shop.util;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenshotUtil {
    public static String scenarioName;
    static Logger log = LoggerFactory.getLogger ( ScreenshotUtil.class );
    private static Scenario scenario;

    public static void setScenario ( Scenario scenario ) {
        ScreenshotUtil.scenario = scenario;
        scenarioName = scenario.getName ( ) + System.currentTimeMillis ( );
    }

    public static void takeScreenshot ( String name ) {
        TakesScreenshot ts = (TakesScreenshot) Browser.getBrowser ( );
        LocalDateTime now = LocalDateTime.now ( );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH_mm_ss" );
        String formatDateTime = now.format ( formatter );
        byte[] source = ts.getScreenshotAs ( OutputType.BYTES );
        String fileName =  name + formatDateTime + ".png";
        scenario.embed
                ( source , "image/png" , fileName);
        Path scenarioPath = Paths.get ( new File ( "target/screenshot/" + scenarioName + "/" ).getPath ( ) );
        try {
            Files.createDirectories ( scenarioPath );
            Files.write ( scenarioPath.resolve ( fileName ) , source );
        } catch (IOException e) {
            log.error ( "Fail to save screenshot" + e.getMessage ( ) );
        }
    }

    public static void scrollToElement (WebElement myItem ) {
        JavascriptExecutor js = (JavascriptExecutor) Browser.getBrowser();
        js.executeScript ( "arguments[0].scrollIntoView();" , myItem );
    }

    public static void highLight ( WebElement myItem ) {
        JavascriptExecutor js = (JavascriptExecutor) Browser.getBrowser ( );
        js.executeScript ( "arguments[0].setAttribute('style', 'border: 3px solid orange;');" , myItem );
    }

    public static void scrollToTop () {
        JavascriptExecutor js = (JavascriptExecutor) Browser.getBrowser();
        js.executeScript ( "window.scrollTo(0,0)" );
    }
}
