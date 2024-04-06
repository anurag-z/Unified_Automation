package org.Base;


import org.Global.GlobalData;
import org.Listeners.SuiteListeners;
import org.Listeners.TestsListeners;
import org.UI_Selenium.DriverManager;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.Global.GlobalData.*;

@Listeners({SuiteListeners.class, TestsListeners.class})
public class Base_Test {
    DriverManager driverManager= DriverManager.getInstance();

    public Base_Test()
    {
        try {
            if(platform.equals("api"))
            {
                InputStream configFile = new FileInputStream(System.getProperty("user.dir") +
                        "/src/test/java/org/Config/API/" + ENV + ".properties");

                envConfig = new Properties();
                envConfig.load(configFile);
            }
            else {
                //Environment specific properties file loading
                InputStream configFile = new FileInputStream(System.getProperty("user.dir") +
                        "/src/test/java/org/Config/Web/" + ENV + ".properties");

                envConfig = new Properties();
                envConfig.load(configFile);
            }
    }
    catch (Exception e)
    {
        throw new RuntimeException(e);
    }
    }
    @BeforeMethod(alwaysRun = true)
    public void Base_Test()
    {
        //ExtentTestManager.startTest("");
       // driverManager.setup();

        if(platform.equals("web"))
        {driverManager.setup();}


    }

    @AfterMethod(alwaysRun = true)
    public void quitdriver()
    {
        if(platform.equals("web"))
        {driverManager.getdriver().close();
            driverManager.getdriver().quit();}
    }



}
