package com.demoqa.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    Logger log = LoggerFactory.getLogger(ScenarioContext.class);

    private static ScenarioContext instance;

    private Map<String, Object> scenarioContext;

    private ScenarioContext() {
        scenarioContext = new HashMap<String, Object>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }


    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

    public void clearScenarioContext() {
        scenarioContext.clear();
        log.info("Scenario Context was cleared");
    }
}
