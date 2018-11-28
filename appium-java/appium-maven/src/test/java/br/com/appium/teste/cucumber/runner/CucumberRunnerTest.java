package br.com.appium.teste.cucumber.runner;

import br.com.appium.teste.test.utils.DriverFactoryManager;
import cucumber.api.SnippetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE,
        features = "resources/features",
        glue = "br/com/appium/teste/steps/definitions",
        tags = {"@teste01","~@unit", "~@notIntegrated"},
        plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm", "pretty"})

public class CucumberRunnerTest {

    @BeforeClass
    public static void tearUp() {
        DriverFactoryManager.appiumServerUp();
        DriverFactoryManager.startDriverByMavenParameter(System.getProperty("environment"));
    }

    @AfterClass
    public static void tearDown() {
        DriverFactoryManager.appiumServerDown();
        DriverFactoryManager.quitDriver();
    }

}