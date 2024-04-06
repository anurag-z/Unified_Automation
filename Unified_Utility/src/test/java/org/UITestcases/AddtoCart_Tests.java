package org.UITestcases;

import org.Base.Base_Test;
import org.Pages.Additems;
import org.Pages.Login;
import org.Pages.MoreOptions;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddtoCart_Tests extends Base_Test {
    Login login= Login.getInstance();
    Additems additems= Additems.getInstance();
    MoreOptions moreOptions= MoreOptions.getInstance();
    @Test(description = "Add items in carts")
    public void addcart() throws InterruptedException, IOException {
        login.Login();
        additems.Addcarts();
    }
}
