package com.demoqa.shop.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        plugin = {"pretty", "html:target/report", "json:target/cucumber.json", "com.demoqa.shop.plugins.TestEventHandlerPlugin"},
        features = {"src/test/resources/features"},
        glue = {"com.demoqa.shop.hooks",
                "com.demoqa.shop.steps"},
        tags = "@Run",
        strict = true,
        monochrome = true,
        stepNotifications = true
)
public class RunCukeTests {
}
