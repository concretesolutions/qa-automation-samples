package br.com.selenium.java_project.enums;

import java.io.File;

public enum OperationSystems {

    MAC_OS_X("drivers/mac/"),
    WINDOWS_7("drivers/windows/"),
    WINDOWS_10("drivers/windows/"),
    LINUX("drivers/linux/");

    private String driverPath;

    OperationSystems(String driverPath){
        this.driverPath = driverPath;
    }

    public String getDriversPath() {
        return new File(driverPath).getAbsolutePath();
    }
}