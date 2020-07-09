package com.demoqa.shop.hooks;

import com.demoqa.shop.pages.HomePage;
import com.demoqa.shop.util.ScreenshotUtil;
import com.demoqa.shop.util.Browser;
import com.demoqa.shop.util.Context;
import com.demoqa.shop.util.ScenarioContext;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    Logger log = LoggerFactory.getLogger ( Hooks.class );

    @Before
    public void before(Scenario scenario) {
        log.info("Execution of scenario '{}' has been started", scenario.getName());
        ScreenshotUtil.setScenario(scenario);
        WebDriver browser = Browser.getBrowser();
        HomePage homePage = new HomePage(browser);
        homePage.clickDismiss();
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, homePage);
        log.info("'Before' block has been executed");
    }

    @After
    public void after ( Scenario scenario ) {
        if (scenario.isFailed ( ))
            ScreenshotUtil.takeScreenshot ( "onFail" );
        Browser.closeBrowser ( );
        ScenarioContext.getInstance ( ).clearScenarioContext ( );
    }
}
