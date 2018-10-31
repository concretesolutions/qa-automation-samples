package br.com.selenium.java_project.utils;

import java.io.InputStream;
import cucumber.api.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureHelper {

    private static void screenShot(String status, Scenario scenario) {
        byte[] screenshootBytes = ((TakesScreenshot) Page.getDriver()).getScreenshotAs(OutputType.BYTES);
        InputStream screenshootStream = new ByteArrayInputStream(screenshootBytes);
        Allure.addAttachment(scenario.getName() +" - "+ status, screenshootStream);
    }

    public static void saveScreenshootOfScenario(Scenario scenario) {
        if (!scenario.isFailed()) {
            screenShot("PASSED", scenario);

        } else {
            screenShot("FAILED", scenario);
        }
    }
}