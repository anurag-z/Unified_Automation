package org.UI_Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.Global.GlobalData.execution;
import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class DriverManager {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static DriverManager single_instance=null;

    private DriverManager() {
        // Private constructor to prevent instantiation
    }


    public WebDriver getdriver()
    {
        return driver.get();
    }

    public static synchronized DriverManager getInstance()
    {
        if(single_instance==null)
            single_instance= new DriverManager();
        return  single_instance;
    }

    public void setup()
    {
        try {
            if (execution.equals("remote")) {
                //WebDriverManager.chromedriver().setup();
                //driver.set(new ChromeDriver());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.setAcceptInsecureCerts(true);
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                //   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options));

            }
            else {

               WebDriverManager.chromedriver().setup();
             /* System.out.println(System.getProperty("user.dir")+"/chromedriver");
                      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver-linux64/chromedriver");
*/
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.setAcceptInsecureCerts(true);
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                //   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                options.addArguments("--remote-allow-origins=*");
             //   options.addArguments("--headless=new");
                WebDriver drivers= new ChromeDriver(options);
                driver.set(drivers);
            }
        }
        catch (Exception e)
        {}
    }


}
