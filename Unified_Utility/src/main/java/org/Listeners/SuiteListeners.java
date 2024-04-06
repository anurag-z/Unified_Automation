package org.Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class SuiteListeners  implements ISuiteListener {


    @Override
    @BeforeSuite(alwaysRun = true)
    public void onStart(ISuite ISuite)
    {

        System.out.println("########Before-Suite##########");
    }

    @AfterSuite
    public void onFinish(ISuite ISuite)
    {
        System.out.println("########After-Suite##########");


    }

}

