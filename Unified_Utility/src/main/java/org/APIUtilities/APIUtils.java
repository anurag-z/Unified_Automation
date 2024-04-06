package org.APIUtilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Connection;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.APIUtilities.ApiLoggingUtil.getLoggingFilter;

public class APIUtils {

    public Response Postresponse()
    {
        RequestSpecification rs=given().contentType("").header("","");

        Response rps= rs.relaxedHTTPSValidation().when().filters(getLoggingFilter())
                .basePath("")
                .baseUri("")
                .body("")
                .post()
                .then()
                .extract().response();

return  rps;

    }
}
