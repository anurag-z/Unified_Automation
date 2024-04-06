package org.Extent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {

        File reportfile= new File(System.getProperty("user.dir")+"/Extent/Teststst.html");
        try {
            if (!reportfile.exists()) {
                reportfile.createNewFile();

            }
        }
        catch (Exception e)
        {


        }
        extent = new ExtentReports(System.getProperty("user.dir")+"/Extent/Teststst.html",true);
        return  extent;
    }
}
