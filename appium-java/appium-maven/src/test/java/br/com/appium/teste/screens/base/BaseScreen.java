package br.com.appium.teste.screens.base;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import br.com.appium.teste.test.utils.DriverFactoryManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseScreen extends MobileElement {

    public BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactoryManager.getDriver()), this);
    }

    protected void waitForInsvisibilityOfElement(By locator) {
        new WebDriverWait(DriverFactoryManager.getDriver(), 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForVisibilityOfElement(By locator) {

        new WebDriverWait(DriverFactoryManager.getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}