package org.APITestcases;


import com.google.gson.Gson;
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
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static org.Global.GlobalData.envConfig;

public class Booking_API extends Base_Test {



    @Test(groups = "api",description = "Check API Health")
    public void Checkhealth()
    {

        Response rp= ResponseSpec.getRequestSpec(envConfig.getProperty("baseUri"),envConfig.getProperty("Healthcheck_endpoint"),new HashMap<>());
        int status=rp.statusCode();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(201,status);

        ExtentTestManager.getTest().log(LogStatus.INFO,rp.asString());

        softAssert.assertAll();
    }

    @Test(groups = "api",description = "Create Booking using Pojo class")
    public void createBooking_POJO()
    {
        Booking booking= new Booking();
        booking.setFirstname("testing");
        booking.setLastname("ingtest");
        booking.setTotalprice(30);
        booking.setDepositpaid(true);

        Booking.BookingDates bookingDates= new Booking.BookingDates();
        bookingDates.setCheckIn("2018-01-01");
        bookingDates.setCheckOut("2019-01-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("lunch");
        Gson gson = new Gson();

        String requestBody = gson.toJson(booking);

        System.out.println(requestBody);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Body"+ requestBody);
        Response rs= ResponseSpec.postRequestionSpec(requestBody,envConfig.getProperty("baseUri"),envConfig.getProperty("Getbooking_endpoint"));
        ExtentTestManager.getTest().log(LogStatus.INFO,"Response Body"+ rs.asString());
        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(200,rs.statusCode());
        softAssert.assertAll();
        System.out.println(rs.asString());
    }
    @Test(groups = "api",description = "Token generation using JSON Object")
    public void CreateToken()
    {


        JsonObject js= new JsonObject();
        js.addProperty("username","admin");
        js.addProperty("password","password123");
        String body=js.toString();

        Response rs= ResponseSpec.postRequestionSpec(body,envConfig.getProperty("baseUri"),envConfig.getProperty("Token_endpoint"));

        JsonElement element = new com.google.gson.JsonParser().parse(rs.getBody().asString());
        JsonObject jsonObject= element.getAsJsonObject();
        String token =jsonObject.get("token").getAsString();

        System.out.println(rs.asString());
        ExtentTestManager.getTest().log(LogStatus.INFO,rs.asString());
       // ExtentTestManager.getTest().log(LogStatus.PASS,rs.asString());
        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(200,rs.statusCode());
        softAssert.assertAll();



    }
  //  {"bookingid":2856,"booking":{"firstname":"testing","lastname":"ingtest","totalprice":30,"depositpaid":true,"bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"additionalneeds":"lunch"}}



    @Test(groups = "api",description = "Get booking details....")
    public void GetBooking()
    {


        HashMap<String ,String>  query= new HashMap<>();
        query.put("firstname","testing");
        query.put("lastname","ingtest");

        Response rp= ResponseSpec.getRequestSpec(envConfig.getProperty("baseUri"),envConfig.getProperty("Getbooking_endpoint"),new HashMap<>());
        ExtentTestManager.getTest().log(LogStatus.INFO,rp.asString());
        System.out.println(rp.asString());
        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(200,rp.statusCode());
        softAssert.assertAll();

    }

}
