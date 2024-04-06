package org.Pages;

import com.relevantcodes.extentreports.LogStatus;
import org.Base.Base_Test;
import org.Extent.ExtentTestManager;
import org.UI_Selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoreOptions extends Base_Test {


    private static MoreOptions single_instance=null;
    private MoreOptions()
    {}
    public static synchronized MoreOptions getInstance()
    {
        if(single_instance==null)
            single_instance= new MoreOptions();
        return  single_instance;
    }

    By moreoptionbutton= By.id("react-burger-menu-btn");
    By menulist=By.xpath("//*[@class='bm-item-list']/a");


    public void checkmoreoptionlist() throws InterruptedException {
        DriverManager driverManager= DriverManager.getInstance();

        WebDriverWait wait= new WebDriverWait(driverManager.getdriver(), Duration.ofSeconds(2));
        WebElement mb= wait.until(ExpectedConditions.elementToBeClickable(moreoptionbutton));
        mb.click();
        Thread.sleep(3000);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Clicked on left nav bar");

        List<WebElement> lists= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menulist));


        ExtentTestManager.getTest().log(LogStatus.INFO,"Number of Options avaialable in nav bar..."+lists.size());
      //  lists.get(1).click();
        Thread.sleep(5000);



    }
}
