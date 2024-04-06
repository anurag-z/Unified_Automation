package org.Listeners;


import com.relevantcodes.extentreports.LogStatus;
import org.Extent.ExtentTestManager;
import org.Global.GlobalData;
import org.UI_Selenium.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestsListeners implements ITestListener {

    static DriverManager driverManager= DriverManager.getInstance();
    static String snappath=null;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getDescription()+ "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        ExtentTestManager.getTest().assignCategory(result.getMethod().getRealClass().getSimpleName());
    }
@Override
    public void onTestSuccess(ITestResult result)
    {
        /*File scrFile = ((TakesScreenshot)driverManager.getdriver()).getScreenshotAs(OutputType.FILE);
        File f = FileUtils.getFile(System.getProperty("user.dir")+"\\errorScreenshots\\" + result.getTestName()+"-.jpg");

        if(f.exists())
        {       f.delete();}
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\errorScreenshots\\" + result.getTestName()+"-.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   */  if(GlobalData.platform.equals("web")) {
        String path = System.getProperty("user.dir") + "/errorScreenshots/";
        String img = ExtentTestManager.getTest().addScreenCapture(this.captureScreenshot(path));
        System.out.println(img);
        ExtentTestManager.getTest().log(LogStatus.PASS, "pic" + img);
        ExtentTestManager.endtest();
    }
    }
@Override
    public  void onTestFailure(ITestResult result)
    {
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Failed.....");
        ExtentTestManager.endtest();

    }

    @Override
    public void onFinish(ITestContext result)
    {
       /* File scrFile = ((TakesScreenshot)driverManager.getdriver()).getScreenshotAs(OutputType.FILE);

        File f = FileUtils.getFile(System.getProperty("user.dir")+"\\errorScreenshots\\" + result.getName()+"-.jpg");
        if(f.exists())
        {       f.delete();}
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\errorScreenshots\\" + result.getName()+"-.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/        ExtentTestManager.endtest();
        ExtentTestManager.endTest();
    }

    public static String captureScreenshot(String snapshotsPath){

        try{


            File scrFile = ((TakesScreenshot)driverManager.getdriver()).getScreenshotAs(OutputType.FILE);
            System.out.println("TakesScreenshot Path:: "+scrFile.getAbsolutePath());
            //The below method will save the screen shot in d drive with name "screenshot.png"
            String name = scrFile.getName();
            File desFile=new File(snapshotsPath+name);
            System.out.println("snapshotsPath Path:: "+desFile.getAbsolutePath());
            FileUtils.copyFile(scrFile, desFile);
//            String newPath = System.getProperty("user.dir") +"/";
//            snappath = newPath+snapshotsPath+name;
            snappath=desFile.getCanonicalPath();

        }catch(Exception e){

            System.out.println("Issue with snapshot capture");

        }
        return snappath;
    }
}
