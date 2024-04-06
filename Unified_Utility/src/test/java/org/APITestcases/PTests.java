package org.APITestcases;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;

import org.API_DTO.Booking;
import org.Base.Base_Test;
import org.Extent.ExtentTestManager;
import org.UI_Selenium.DriverManager;
import org.testng.annotations.Test;
import org.UtilitiesAPI.*;

import java.util.HashMap;

import static org.Global.GlobalData.envConfig;

public class PTests extends Base_Test {

    public static  final String tested= System.getProperty("tessadt","");
    DriverManager driverManager= DriverManager.getInstance();
    @Test(groups = "api")
    public void abc()
    {
        System.out.println("testing.......123"+tested);

        ExtentTestManager.getTest().log(LogStatus.FAIL,"asd");

    }

    @Test(groups = "api")
    public void abcd()
    {
        System.out.println("testing.......123"+tested);


    }
    @Test(groups = "api")
    public void abcg()
    {
        System.out.println("testing.......123"+tested);



        JsonObject js= new JsonObject();
        js.addProperty("username","admin");
        js.addProperty("password","password123");
        String body=js.toString();

        Response rs= ResponseSpec.postRequestionSpec(body,envConfig.getProperty("baseUri"),envConfig.getProperty("Token_endpoint"));

        JsonElement element = new com.google.gson.JsonParser().parse(rs.getBody().asString());
        JsonObject jsonObject= element.getAsJsonObject();
        String token =jsonObject.get("token").getAsString();

        System.out.println(rs.asString());

        HashMap<String ,String>  query= new HashMap<>();
        query.put("firstname","sally");
        query.put("lastname","brown");

        Response rp= ResponseSpec.getRequestSpec(envConfig.getProperty("baseUri"),envConfig.getProperty("Getbooking_endpoint"),query);

        System.out.println(rp.asString());

        Booking bk = new Booking();
        bk.setFirstname("");
        bk.setLastname("");

        Booking.BookingDates bd= new Booking.BookingDates();
        bd.setCheckIn("");
        bd.setCheckIn("");

        bk.setBookingdates(bd);


        JsonObject jo= new JsonObject();
        jo.addProperty("","");
        jo.addProperty("","");

        JsonObject ji = new JsonObject();
        ji.addProperty("","");
        ji.addProperty("","");

        jo.add("",ji);



    }

}
