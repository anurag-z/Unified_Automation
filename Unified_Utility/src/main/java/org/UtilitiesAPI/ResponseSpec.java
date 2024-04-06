package org.UtilitiesAPI;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
public class ResponseSpec {


    public  static Response postRequestionSpec(String body,String baseUri,String basepath)
    {

       RequestSpecification rs= given().contentType("application/json");
       return  CommonResponseSpec.PostRequest(rs,body,baseUri,basepath);

    }


    public static Response getRequestSpec(String baseUri,String basepath,HashMap<String,String> query)
    {
        RequestSpecification rs = given().queryParams(query);

        return CommonResponseSpec.GetRequest(rs,baseUri,basepath);
    }
}
