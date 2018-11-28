package br.com.appium.teste.test.utils;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.appium.teste.test.constants.Constants;
import br.com.appium.teste.test.devices.capabilities.AndroidDevicesCapabilities;
import br.com.appium.teste.test.devices.capabilities.IOSDevicesCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactoryManager {

    private static AppiumDriver<?> appiumDriver;
    private static AppiumDriverLocalService service;


    public static AppiumDriver<?> startDriverByMavenParameter(String mavenEnvironment) {

        if (appiumDriver == null) {

            try {

                if (mavenEnvironment.contains("ANDROID")) {
                    appiumDriver = new AndroidDriver<>(new URL(Constants.APPIUM_URL_DEV), AndroidDevicesCapabilities.valueOf(mavenEnvironment).getAndroidCapabilitiesFromPlataform());
                } else if (mavenEnvironment.contains("IPHONE")) {
                    appiumDriver = new IOSDriver<>(new URL(Constants.APPIUM_URL_DEV), IOSDevicesCapabilities.valueOf(mavenEnvironment).getIOSCapabilitiesFromPlataform());
                }

            } catch (IllegalArgumentException e) {
                System.out.println(" ==== AVISO : Por favor selecionar um dos devices abaixo para executar os testes ==== ");
                AndroidDevicesCapabilities.showAvaliableAndroidDevices();
                IOSDevicesCapabilities.showAvaliableIphoneDevices();
                System.exit(1);
            } catch (UnreachableBrowserException e) {
                System.out.println(" ==== AVISO : Por favor verifique se foi passado uma url válida para executar os testes ou se já inicializou o Appium. ====");
                System.exit(1);
            } catch (MalformedURLException e) {
                System.out.println(" ==== AVISO : Por favor verifique a url que foi informada para executar os testes. ====");
                System.exit(1);
            }
        }

        return appiumDriver;
    }

    public static AppiumDriver<?> getDriver() {
        return appiumDriver;
    }

    public static void reLaunchApp() {
        if (appiumDriver != null) {
            appiumDriver.launchApp();
        }
    }

    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    public static String getPageHierarchy() {
        return appiumDriver.getPageSource();
    }

    public static void appiumServerUp() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }


    public static void appiumServerDown() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.stop();
    }
}

