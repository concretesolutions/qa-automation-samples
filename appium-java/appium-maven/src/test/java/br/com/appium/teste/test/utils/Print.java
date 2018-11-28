package br.com.appium.teste.test.utils;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Print {

    public static void takeScreenShot(Scenario scenario) {

        File scrFile = ((TakesScreenshot) DriverFactoryManager.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, (new File("./evidence", scenario.getName() + " - " + scenario.getStatus().toUpperCase() + ".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
