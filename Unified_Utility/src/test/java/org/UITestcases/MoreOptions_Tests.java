package org.UITestcases;

import org.Base.Base_Test;
import org.Pages.Additems;
import org.Pages.Login;
import org.Pages.MoreOptions;
import org.testng.annotations.Test;

import java.io.IOException;

public class MoreOptions_Tests extends Base_Test {
    Login login= Login.getInstance();
    Additems additems= Additems.getInstance();
    MoreOptions moreOptions= MoreOptions.getInstance();
    @Test(description = "Check options in left nav bar")
    public void Aboutus() throws InterruptedException, IOException {
        login.Login();
       moreOptions.checkmoreoptionlist();
    }
}
