package br.com.appium.teste.test.utils;

import br.com.appium.teste.screens.base.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class Commons extends BaseScreen {

    public static void scroll(int startX, int startY, int endX, int endY) {
        new TouchAction(DriverFactoryManager.getDriver()).press(startX, startY).waitAction().moveTo(endX, endY).release().waitAction().perform();
    }

    public static void holdElement(MobileElement mobileElement) {
        new TouchAction(DriverFactoryManager.getDriver()).longPress(mobileElement).perform();
    }

    public static void holdElementiOS(MobileElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactoryManager.getDriver();
        HashMap<String, String> tapObject = new HashMap<String, String>();
        tapObject.put("element", ((RemoteWebElement) element).getId());
        tapObject.put("duration", "2");
        js.executeScript("mobile: touchAndHold", tapObject);
    }

    public static void swipeiOS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactoryManager.getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: swipe", scrollObject);
    }

    public static void swipeInvertiOS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactoryManager.getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);
    }

    public static void dataPicker(MobileElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactoryManager.getDriver();
        HashMap<String, String> picker = new HashMap<String, String>();
        picker.put("order", "next");
        picker.put("offset", "0.15");
        picker.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: selectPickerWheelValue", picker);
    }

    public static void swipe() {
        new TouchAction(DriverFactoryManager.getDriver()).press(300, 1000).waitAction().moveTo(300, 50).release().perform();
    }

    public static void swipeInvert() {
        new TouchAction(DriverFactoryManager.getDriver()).press(300, 50).waitAction().moveTo(300, 1000).release().perform();
    }

}
