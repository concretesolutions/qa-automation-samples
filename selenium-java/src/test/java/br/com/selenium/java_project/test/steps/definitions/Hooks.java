package br.com.selenium.java_project.test.steps.definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import br.com.selenium.java_project.enums.Browsers;
import br.com.selenium.java_project.utils.AllureHelper;

public class Hooks {

    @After
    public void afterEachScenario(Scenario scenario) {
        AllureHelper.saveScreenshootOfScenario(scenario);
        Browsers.quitDriver();
    }
}