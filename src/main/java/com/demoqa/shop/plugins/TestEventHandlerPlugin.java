package com.demoqa.shop.plugins;

import com.demoqa.shop.util.CreateReport;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;

import java.io.File;
import java.util.Collections;


public class TestEventHandlerPlugin implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
    }

    private EventHandler<TestRunFinished> teardown = event -> {
        //run code after all tests
        new CreateReport().generateReportForJsonFiles(new File("target/"),
                Collections.singletonList("target/cucumber.json"));
    };

}

