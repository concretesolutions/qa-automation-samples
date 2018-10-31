package br.com.selenium.java_project.enums;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import br.com.selenium.java_project.utils.DriverFactory;
import br.com.selenium.java_project.utils.HandleProperties;

public enum Browsers {

    IE_WINDOWS("webdriver.ie.driver", "\\IEDriverServer.exe"),
    MOZILLA_WINDOWS("webdriver.gecko.driver", "\\geckodriver.exe"),
    CHROME_WINDOWS("webdriver.chrome.driver", "\\chromedriver.exe"),
    EDGE_WINDOWS("webdriver.edge.driver", "\\MicrosoftWebDriver.exe"),
    CHROME_MAC("webdriver.chrome.driver", "/chromedriver");

	public static WebDriver webDriver;
    private String browserType;
    private String executable;

    Browsers(String browserType , String executable){
        this.browserType = browserType;
        this.executable = executable;
    }
    
    public String getBrowserType(){
        return browserType;
    }

    public String getExecutable(){
        return executable;
    }

    public static void showAvaliableBrowsersOptions(){
        for (Browsers browsers : Browsers.values()) {
            System.out.println("======= " . concat(browsers.name()));
        }
    }
    
    public WebDriver createDriverInstance() {
        switch (browserType) {
            case "webdriver.ie.driver":
                return new InternetExplorerDriver();
            case "webdriver.gecko.driver":
                return new FirefoxDriver();
            case "webdriver.chrome.driver":
                return new ChromeDriver();
            case "webdriver.edge.driver":
                return new EdgeDriver();
            default:
                return null;
        }
    }
    
    public static void setWebDriver() {
		if (Boolean.parseBoolean(System.getProperty("url_concrete"))) {
			try {
				String urlConcrete = System.getProperty("urlConcrete") != null ? System.getProperty("urlConcrete")
						: HandleProperties.getValue("url_concrete");
				webDriver = new RemoteWebDriver(new URL(urlConcrete), new ChromeOptions());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			webDriver = DriverFactory.createDriver(System.getProperty("browser"));
		}
	}
    
    public static void quitDriver() {
    	webDriver.quit();
		webDriver = null;
	}
}