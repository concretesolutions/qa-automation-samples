package br.com.appium.teste.test.devices.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import br.com.appium.teste.test.utils.Utils;

import java.io.File;

public enum AndroidDevicesCapabilities {


    ANDROID_OREO_DEV("capabilities/android-oreo-dev.json"),
    ANDROID_FISICO("capabilities/android-fisico.json");


    private String path;

    AndroidDevicesCapabilities(String path) {
        this.path = path;
    }

    public DesiredCapabilities getAndroidCapabilitiesFromPlataform() {
        DesiredCapabilities androidCapabilities = Utils.pathToDesiredCapabilitites(this.path);
        androidCapabilities.setCapability("app", new File("apps/Appium.apk").getAbsolutePath());
        return androidCapabilities;
    }

    public static void showAvaliableAndroidDevices() {
        System.out.println("======= ANDROID DEVICES ====== ");
        for (AndroidDevicesCapabilities androidDevicesCapabilities : AndroidDevicesCapabilities.values()) {
            System.out.println(androidDevicesCapabilities.name());
        }
    }
}
