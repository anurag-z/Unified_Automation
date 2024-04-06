package org.APIUtilities;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class APIMethods {




        /**
         * @implNote This method is used for GET type API's with params and content type application/json.
         */
        public static Response getApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                              HashMap<String, String> parameterMap, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap);

            return CommonResponseSpec.commonResponseSpecGET(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with params, body and content type application/json.
         */
        public static Response getApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                              HashMap<String, String> parameterMap, HashMap<?, ?> body, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecGET(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with params, body and content type application/json.
         */
        public static Response getApiResponse(String baseURL, String basePath) {

            RequestSpecification requestSpecification = given();

            return CommonResponseSpec.commonResponseSpecGET(baseURL, basePath, new HashMap<>(), new JSONObject().toJSONString(), requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with params and content type application/xml.
         */
        public static Response getXmlApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                 HashMap<String, String> parameterMap, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.XML)
                    .pathParams(parameterMap);

            return CommonResponseSpec.commonResponseSpecGETXml(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with query and content type application/xml.
         */
        public static Response getXmlApiResponseQueryParam(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                           HashMap<String, String> parameterMap, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.XML)
                    .queryParams(parameterMap);


            return CommonResponseSpec.commonResponseSpecGETXml(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with params and body where content type is application/x-www-form-urlencoded.
         * Takes HashMap for Body
         */
        public static Response getApiResponseURLEncoded(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                        HashMap<String, String> parameterMap, HashMap<String, Object> body, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .formParams(body)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");

            return CommonResponseSpec.commonResponseSpecGET(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for GET type API's with params and body where content type is application/x-www-form-urlencoded.
         * It is overridden method. Here it takes String for Body.
         */
        public static Response getApiResponseURLEncoded(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                        HashMap<String, String> parameterMap, String body, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .body(body)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");


            return CommonResponseSpec.commonResponseSpecGET(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        public static Response postApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                               HashMap<?, ?> bodyMap, HashMap<String, String> parameterMap,
                                               String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .queryParams(parameterMap)
                    .body(bodyMap).relaxedHTTPSValidation();

            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * This method is used when BODY is a TEXT/PLAIN and NOT JSON.
         * This is an overrided method from postApiResponse
         *
         * @implNote apiResponse = postApiResponse(apienvironment.BaseUrl_uapi(), Constants.UapiConstants.U_API_V1PASSWORDFORGOTEMAIL, headers, "body", new HashMap<>(), schema.toJSONString());
         */
        public static Response postApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                               String body, HashMap<String, String> parameterMap,
                                               String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }


        /**
         * @implNote This method is used for POST type API's where the body is Object Parameter.
         */
        public static Response graphQLpostApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                      Object body) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .urlEncodingEnabled(false)
                    .relaxedHTTPSValidation();

            return CommonResponseSpec.commonResponseSpecPOSTGraphQL(baseURL, basePath, headersMap, requestSpecification);
        }

        /**
         * This method is used when NO BODY is required and QUERY PARAMS are passed in Request URI
         *
         * @implNote apiResponse = ApiResponse.postApiResponseQueryParams(apienvironment.BaseUrl_uapi(), Constants.UapiConstants.U_API_V1LOGINMOBILE_PATH, headers,paramMap,schema.toJSONString());
         */
        public static Response postApiResponseQueryParams(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                          HashMap<String, String> queryParams, String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .queryParams(queryParams);

            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * This method is used when NO BODY is required
         *
         * @implNote apiUpdateResponse = putApiResponseQueryParams(apienvironment.BaseUrl_profileAPI(), Constants.UapiConstants.U_API_CREATE_PROFILE_V2_PATH + id, headers, new HashMap<>(), schema.toJSONString());
         */
        public static Response putApiResponseQueryParams(String baseURL, String basePath, HashMap<String, String> headersMap, HashMap<String, String> queryParams, String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.XML)
                    .queryParams(queryParams);

            return CommonResponseSpec.commonResponseSpecPUT(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }


        /**
         * @implNote This method is used for PATCH type API's where content type is JSON.
         * Takes hashmap for Body.
         */
        public static Response patchApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                HashMap<Object, Object> bodyMap, HashMap<String, String> parameterMap,
                                                String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(bodyMap);

            return CommonResponseSpec.commonResponseSpecPATCH(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * This method is used when BODY is a TEXT/PLAIN and NOT JSON.
         */
        public static Response patchApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                String body, HashMap<String, String> parameterMap,
                                                String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body)
                    .relaxedHTTPSValidation();

            return CommonResponseSpec.commonResponseSpecPATCH(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }
        public static Response delete(String baseURL, String basePath, HashMap<String, String> headersMap,String body,
                                      HashMap<String, String> parameterMap, String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);
            return CommonResponseSpec.commonResponseSpecDELETECDN(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }
        /**
         * @implNote This method is used for POST type API's where content type is application/x-www-form-urlencoded.
         * Takes hashmap for Body.
         */
        public static Response postApiResponseURLEncoded(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                         HashMap<String, Object> bodyMap, HashMap<String, String> parameterMap,
                                                         String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .formParams(bodyMap)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");

            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for POST type API's where content type is application/x-www-form-urlencoded.
         * It is overridden method. Here it takes String for Body.
         */
        public static Response postApiResponseURLEncoded(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                         String body, HashMap<String, String> parameterMap,
                                                         String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .body(body)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");


            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        /**
         * @implNote This method is used for POST type API's where content type is multipart/form-data.
         * Send the parameters of body in formData. formData takes hashmap.
         */
        public static Response postApiResponseFromData(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                       HashMap<String, Object> bodyMap, HashMap<String, String> parameterMap,
                                                       HashMap<String, Object> formData, String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .formParams(bodyMap)
                    .contentType("multipart/form-data");

            for (Map.Entry<String, Object> entry : formData.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                requestSpecification.multiPart(key, value);
            }

            return CommonResponseSpec.commonResponseSpecPOST(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }


        public static Response delete(String baseURL, String basePath, HashMap<String, String> headersMap, HashMap<?, ?> bodyMap,
                                      HashMap<String, String> parameterMap, String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(bodyMap);
            return CommonResponseSpec.commonResponseSpecDELETE(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }
        public static Response deleteCDN(String baseURL, String basePath, HashMap<String, String> headersMap, HashMap<?, ?> bodyMap,
                                         HashMap<String, String> parameterMap, String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(bodyMap);
            return CommonResponseSpec.commonResponseSpecDELETECDN(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        //static String apiDocBaseUrl="https://apidocs.zee5.com/";
        public static Response getDbDetails(String baseURL, String basePath, HashMap<String, String> parameterMap) {
            Response response = given()
                    .params(parameterMap)
                    .when()
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .get().then().extract().response();
            return response;
        }

        public static Response getJsonFromAPIDoc(String baseURL, String basePath) {
            Response response = given()
                    .urlEncodingEnabled(false)
                    .when()
                    .baseUri(baseURL)
                    .basePath(basePath)
                    .get().then().extract().response();
            return response;
        }

       /* public static HashMap<String, String> requestHeaders() {

            HashMap<String, String> headers = new HashMap<>();
            headers.put(X_ACCESS_TOKEN, Constants.TokenConstant.X_ACCESS_TOKEN_VALUE2);
            headers.put(AUTHORIZATION, AUTHORIZATION_TOKEN_VALUE);
            headers.put("ref-origin-id", "2");
            return headers;
        }*/

        /**
         * This method is used to pass common headers like accept and content type
         * this can be used especially when You want to include devide id and esk in the headers.
         */
/*        public static HashMap<String, String> requestHeaders(String deviceId, String esk) {

            HashMap<String, String> headers = new HashMap<>();
            headers.put(ACCEPT, CONTENT_TYPE_JSON);
            headers.put(CONTENT_TYPE, CONTENT_TYPE_JSON);
            headers.put(DEVICE_ID, deviceId);
            headers.put(ESK, esk);
            return headers;
        }

        *//**
         * This method is used to pass common headers like accept and content type
         * this can be used especially when You want to include devide id and esk in the headers.
         *//*
        public static HashMap<String, String> requestHeadersNoDeviceIdEsk() {

            HashMap<String, String> headers = new HashMap<>();
            headers.put(ACCEPT, CONTENT_TYPE_JSON);
            headers.put(CONTENT_TYPE, CONTENT_TYPE_JSON);
            return headers;
        }

        public static HashMap<String, String> cdnRequestHeaders() {

            HashMap<String, String> headers = new HashMap<>();
            headers.put(CONTENT_TYPE, CONTENT_TYPE_JSON);
            return headers;
        }

        public static HashMap<String, String> azureRequestHeaders() {
            HashMap<String, String> headers = new HashMap<>();
            headers.put(CONTENT_TYPE, CONTENT_TYPE_JSON);
            return headers;
        }*/

        /**
         * This method is used for PUT type API's, takes STRING as input for BODY.
         *
         * @implNote :  apiResponse = putApiResponse(apienvironment.BaseUrl_uapi(), Constants.UapiConstants.U_API_CONFIRMEMAIL_V1_PATH, headers, body, new HashMap<>(), schema.toJSONString());
         */
        public static Response putApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap, String body,
                                              HashMap<String, String> parameterMap, String ResponseSchemaFileName) {
       /* if (!body.matches("java.lang.String")) {
            convertStringToMap(body);
        }*/
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecPUT(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);


        }

        /**
         * This method is used for PUT type API's, takes Hashmap as input for BODY.
         * This is an overrided method for PUTAPIRESPONSE above- only body data type differs.
         * Will optimise it in future.
         *
         * @implNote :  apiResponse = putApiResponse(apienvironment.BaseUrl_uapi(), Constants.UapiConstants.U_API_CONFIRMEMAIL_V1_PATH, headers, body, new HashMap<>(), schema.toJSONString());
         */
        public static Response putApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                              HashMap<?, ?> body, HashMap<String, String> parameterMap,
                                              String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecPUT(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        public static Response putApiResponseHTML(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                  HashMap<?, ?> body, HashMap<String, String> parameterMap
        ) {

            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecPUTHTML(baseURL, basePath, headersMap, requestSpecification);
        }

        /**
         * @implNote This method is used for PUT type API's where content type is application/x-www-form-urlencoded.
         * Takes hashmap for Body.
         */
        public static Response putApiResponseURLEncoded(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                        HashMap<String, Object> body, HashMap<String, String> parameterMap,
                                                        String ResponseSchemaFileName) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .formParams(body)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");

            return CommonResponseSpec.commonResponseSpecPUT(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);

        }

        /**
         * @implNote This method is used to generate authorization token.
         */
        public static Response postApiResponseForGetToken(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                          HashMap<String, Object> bodyMap, HashMap<String, String> parameterMap) {
            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .formParams(bodyMap)
                    .contentType("application/x-www-form-urlencoded; charset=utf-8");

            return CommonResponseSpec.commonResponseSpecPOSTForGetToken(baseURL, basePath, headersMap, requestSpecification);
        }

        public static String generateBodyAsString(HashMap<String, Object> data) {
            String test = "";
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                test = test + entry.getKey() + "=" + entry.getValue() + "&";
            }
            StringBuffer bodyString = new StringBuffer(test);
            bodyString.deleteCharAt(bodyString.length() - 1);
            return bodyString.toString();
        }

        /**
         * This method is used to generate authorization token for content type as JSON.
         */
      /*  public static Response postApiResponseForGetTokenJSONBody(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                                  HashMap<Object, Object> bodyMap, HashMap<String, String> parameterMap) {
            RequestSpecification requestSpecification = given()
                    .params(parameterMap)
                    .body(bodyMap)
                    .contentType(CONTENT_TYPE_JSON);

            return CommonResponseSpec.commonResponseSpecPOSTForGetToken(baseURL, basePath, headersMap, requestSpecification);
        }*/

        /**
         * @implNote This method is used for GET type API's where we get html type of response.
         */
        public static Response getApiResponseHtml(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                  HashMap<String, String> parameterMap) {

            RequestSpecification requestSpecification = given()
                    .params(parameterMap);

            return CommonResponseSpec.commonResponseSpecGETHtml(baseURL, basePath, headersMap, requestSpecification);
        }

        /**
         * This method is used for a POST API which returns a HTML response.
         */
        public static Response postApiResponseHTML(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                   HashMap<Object, Object> body, HashMap<String, String> parameterMap,

                                                   String ResponseSchemaFileName) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .params(parameterMap)
                    .body(body);

            return CommonResponseSpec.commonResponseSpecPOSTHtml(baseURL, basePath, headersMap, ResponseSchemaFileName, requestSpecification);
        }

        public static Response postApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON);
            return CommonResponseSpec.spannerResponseSpecPOST(baseURL, basePath, headersMap, requestSpecification);
        }

        /**
         * This method is used for a Spanner POST API which returns a JSON response.
         */

        public static Response spannerPostApiResponse(String baseURL, String basePath, HashMap<String, String> headersMap,
                                                      HashMap<Object, Object> bodyMap, HashMap<String, String> parameterMap) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .queryParams(parameterMap)
                    .urlEncodingEnabled(false)
                    .body(bodyMap);
            return CommonResponseSpec.spannerResponseSpecPOST(baseURL, basePath, headersMap, requestSpecification);
        }

        /**
         * This method is used for a Spanner Delete API which returns a JSON response.
         */

        public static Response spannerDelete(String baseURL, String basePath, HashMap<String, String> headersMap) {
            RequestSpecification requestSpecification = given()
                    .contentType(ContentType.JSON);
            return CommonResponseSpec.spannerResponseSpecDELETE(baseURL, basePath, headersMap, requestSpecification);

        }
    }






