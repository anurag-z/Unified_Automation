package org.APITestcases;

import com.relevantcodes.extentreports.LogStatus;
import org.Base.Base_Test;
import org.Extent.ExtentTestManager;
import org.UI_Selenium.DriverManager;
import org.testng.annotations.Test;

public class Testing extends Base_Test {

  public static  final String tested= System.getProperty("tessadt","");
  DriverManager driverManager= DriverManager.getInstance();
    @Test(groups = "web")
    public void abc()
    {
        System.out.println("testing.......123"+tested);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"asd");

    }

  @Test(groups = "web")
  public void abcd()
  {
    System.out.println("testing.......123"+tested);


  }
  @Test(groups = "web")
  public void abcg()
  {
    System.out.println("testing.......123"+tested);

  }

}
