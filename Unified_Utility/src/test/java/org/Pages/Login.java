package org.Pages;

import com.relevantcodes.extentreports.LogStatus;
import org.Base.Base_Test;
import org.Extent.ExtentManager;
import org.Extent.ExtentTestManager;
import org.UITestcases.Login_Tests;
import org.UI_Selenium.DriverManager;
import org.apache.commons.io.FileUtils;
import static org.Global.GlobalData.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Login extends Base_Test {


    private static Login single_instance=null;
    private Login()
    {}
    public static synchronized Login getInstance()
    {
        if(single_instance==null)
            single_instance= new Login();
        return  single_instance;
    }

    WebDriver driver;

    By username= By.id("user-name");

    By password= By.id("password");
    By loginbtn= By.id("login-button");


    public void Login() throws InterruptedException, IOException {

        DriverManager driverManager= DriverManager.getInstance();

        WebDriverWait wait= new WebDriverWait(driverManager.getdriver(), Duration.ofSeconds(10));
        String url="https://www.saucedemo.com/";
        driverManager.getdriver().navigate().to(envConfig.getProperty("url"));
        ExtentTestManager.getTest().log(LogStatus.INFO,"Navigated to "+url);
        driverManager.getdriver().manage().window().maximize();
        WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(username) );
        el.click();
        driverManager.getdriver().findElement(username).sendKeys("standard_user");

        driverManager.getdriver().findElement(password).sendKeys("secret_sauce");
        ExtentTestManager.getTest().log(LogStatus.PASS,"Entered User name and password");
        driverManager.getdriver().findElement(loginbtn).click();
        ExtentTestManager.getTest().log(LogStatus.PASS,"Successfully logged in...");
        Thread.sleep(5000);
    }

}
