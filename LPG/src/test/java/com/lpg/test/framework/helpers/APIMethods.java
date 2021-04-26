package com.lpg.test.framework.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

/**
 * Every Api Step definition class should extend this class
 */

public class APIMethods {
    private static Gson gson;
    private static String RESOURCE_LOCATION = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Data" + File.separator;
    static {
        RestAssured.baseURI = UrlBuilder.getBasePathURI().toString();

    }

    public static RequestSpecification givenConfig() {
        RestAssured.useRelaxedHTTPSValidation();
        return given().
                header("Accept-Language", "en").header("Content-Type", "application/json");
    }

    public static JSONArray convertApiResponseToJsonArray(Response apiResponse) {
        JSONArray jResponse = new JSONArray();
        try {
            StringBuffer sbResponse = new StringBuffer(apiResponse.prettyPrint());
            JSONParser parser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
            Object object = parser.parse(sbResponse.toString());
            jResponse.add(object);
        } catch (ClassCastException | ParseException e) {

            e.getMessage();
        }
        return jResponse;
    }

    public static JSONArray convertJsonFileToJsonArray(String fileName, String location) {
        JSONArray jsonArray = new JSONArray();
        try {
            String sbResponse = FileUtils.readFileToString(new File(location + fileName),"utf-8");
            JSONParser parser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
            Object object = parser.parse(sbResponse);
            jsonArray.add(object);

        } catch (Exception e) {

            e.getMessage();
        }
        return jsonArray;
    }


}