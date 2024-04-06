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

public class Additems  extends Base_Test {


    private static Additems single_instance=null;
    private Additems()
    {}
    public static synchronized Additems getInstance()
    {
        if(single_instance==null)
            single_instance= new Additems();
        return  single_instance;
    }


    By ButtonList= By.xpath("//div[contains(text(),'')]/ancestor::div[@class='inventory_item_description']//div/button");
    By Button=By.xpath("//div[contains(text(),'Sauce Labs Onesie')]/ancestor::div[@class='inventory_item_description']//div/button");

    By Cartbutton=By.xpath("//a[@class='shopping_cart_link']");

    By backtoshopping=By.xpath(".//button[@class='btn btn_secondary back btn_medium']");

    By Backpack=By.xpath("//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item_description']//div/button");
    public void Addcarts() throws InterruptedException {
        DriverManager driverManager= DriverManager.getInstance();

        List<WebElement> ls= driverManager.getdriver().findElements(ButtonList);

        ExtentTestManager.getTest().log(LogStatus.PASS,"Number of Items available in one page"+ls.size());
        WebDriverWait wait= new WebDriverWait(driverManager.getdriver(), Duration.ofSeconds(5));

        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(driverManager.getdriver().findElement(Button)));
        button.click();
        ExtentTestManager.getTest().log(LogStatus.PASS,"Sauce Labs Backpack Added");

        Thread.sleep(5000);


    }

    public void Addduringcheckout() throws InterruptedException {
        DriverManager driverManager= DriverManager.getInstance();
        WebDriverWait wait= new WebDriverWait(driverManager.getdriver(), Duration.ofSeconds(5));

        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(driverManager.getdriver().findElement(Cartbutton)));
        button.click();
        ExtentTestManager.getTest().log(LogStatus.INFO,"On checkout page..");
        WebElement backbutton= wait.until(ExpectedConditions.elementToBeClickable(driverManager.getdriver().findElement(backtoshopping)));
        backbutton.click();
        ExtentTestManager.getTest().log(LogStatus.PASS,"Back to shopping page");

        Thread.sleep(2000);
        WebElement backpackbutton= wait.until(ExpectedConditions.elementToBeClickable(driverManager.getdriver().findElement(Backpack)));
        backpackbutton.click();



    }





}

