package org.APIUtilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.APIUtilities.ApiLoggingUtil.getLoggingFilter;

public class CommonResponseSpec {





        public static Response commonResponseSpecPOST(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification.relaxedHTTPSValidation()
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .post()
                    .then()
                    .assertThat()
                    .extract().response();

            return response;
        }

    public static Response commonResponseSpecGET(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
        Response response = requestSpecification.relaxedHTTPSValidation()
                .when()
                .urlEncodingEnabled(false)
                .filters(getLoggingFilter())
                .baseUri(baseURL)
                .basePath(basePath)
                .headers(headersMap)
                .get().then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(ResponseSchemaFileName))
                .extract().response();

        return response;
    }
        public static Response commonResponseSpecDELETE(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification.relaxedHTTPSValidation()
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .delete()
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(ResponseSchemaFileName))
                    .extract().response();
            return response;

        }

        public static Response commonResponseSpecDELETECDN(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification.relaxedHTTPSValidation()
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .delete()
                    .then()
                    .assertThat()
                    .extract().response();
            return response;

        }

        public static Response commonResponseSpecPUT(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification.relaxedHTTPSValidation()
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .put()
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(ResponseSchemaFileName))
                    .extract().response();
            return response;
        }
        public static Response commonResponseSpecPUTHTML(String baseURL, String basePath, HashMap<String, String> headersMap, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .put()
                    .then()
                    .assertThat()
                    .extract().response();
            return response;
        }


        public static Response commonResponseSpecPATCH(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .patch()
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(ResponseSchemaFileName))
                    .extract().response();
            return response;
        }

        public static Response commonResponseSpecPOSTForGetToken(String baseURL, String basePath, HashMap<String, String> headersMap, RequestSpecification requestSpecification) {

            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .post()
                    .then()
                    .extract().response();

            if (response.asString().contains("body")) {
                final Pattern pattern = Pattern.compile("body>(.*?)<");
                Matcher match = pattern.matcher(response.asString());
                if (match.find()) {
                    return response;
                }
            } else {
                return response;
            }
            return response;
        }



        public static Response commonResponseSpecGETXml(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .get().then().assertThat()
                    .extract().response();

            return response;
        }

        public static Response commonResponseSpecPOSTGraphQL(String baseURL, String basePath, HashMap<String, String> headersMap, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .post()
                    .then()
                    .assertThat()
                    .extract().response();

            return response;
        }

        public static Response commonResponseSpecGETHtml(String baseURL, String basePath, HashMap<String, String> headersMap, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .get().then().assertThat()
                    .extract().response();

            return response;
        }

        /**
         * This method is used for POST API which returns HTML response.
         *
         * @param baseURL
         * @param basePath
         * @param headersMap
         * @param ResponseSchemaFileName
         * @param requestSpecification
         * @return response
         */
        public static Response commonResponseSpecPOSTHtml(String baseURL, String basePath, HashMap<String, String> headersMap, String ResponseSchemaFileName, RequestSpecification requestSpecification) {
            Response response = requestSpecification.relaxedHTTPSValidation()
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .post()
                    .then()
                    .assertThat()
                    .extract().response();

            return response;
        }

        public static Response spannerResponseSpecDELETE(String baseURL, String basePath, HashMap<String, String> headersMap, RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .delete()
                    .then()
                    .assertThat()
                    .extract().response();
            return response;

        }

        public static Response spannerResponseSpecPOST(String baseURL, String basePath, HashMap<String, String> headersMap,  RequestSpecification requestSpecification) {
            Response response = requestSpecification
                    .when()
                    .filters(getLoggingFilter())
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .headers(headersMap)
                    .post()
                    .then()
                    .assertThat()
                    .extract().response();

            return response;
        }



    }






