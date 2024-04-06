package org.UtilitiesAPI;

import java.util.HashMap;
import java.util.Map;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class CommonResponseSpec {

    public static Response PostRequest(RequestSpecification rs,String body,String baseuri,String basepath)
    {
        Response rp =rs.relaxedHTTPSValidation().
                when().filters(new RequestLoggingFilter()).baseUri(baseuri).basePath(basepath)

                .body(body).post().then().extract().response();

        return  rp;
    }

    public static Response GetRequest(RequestSpecification rs,String baseuri,String basepath)
    {
        Response rp= rs.relaxedHTTPSValidation().when().filters(new RequestLoggingFilter()).baseUri(baseuri).basePath(basepath).
                    get().then().extract().response();
        return  rp;
    }
}
