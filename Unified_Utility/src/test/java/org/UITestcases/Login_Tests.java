package org.UITestcases;

import org.Base.Base_Test;
import org.Global.GlobalData;

import org.Pages.Additems;
import org.Pages.Login;
import org.Pages.MoreOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Login_Tests  extends Base_Test {

    private static final Logger log = LogManager.getLogger(Login_Tests.class);
    SoftAssert softAssert= new SoftAssert();
    Login login= Login.getInstance();
    Additems additems= Additems.getInstance();
    MoreOptions moreOptions= MoreOptions.getInstance();

    @Test(description = "Login Test")
    public void login() throws InterruptedException, IOException {
        login.Login();

    }
    @Test(groups = GlobalData.grouping.login ,description = "End to End Test")
    public void Endtoend() throws InterruptedException, IOException {
        login.Login();
        additems.Addcarts();
        additems.Addduringcheckout();
        Thread.sleep(5000);
        softAssert.assertEquals("","");
        softAssert.assertAll();

    }

}
