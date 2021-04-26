package com.lpg.test.services;

import com.jayway.restassured.path.json.JsonPath;
import com.lpg.test.enums.EndPOints;
import com.lpg.test.framework.helpers.APIMethods;
import com.jayway.restassured.response.Response;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class ReqResAPI extends APIMethods {
    static String url = EndPOints.USER_REGISTRATION.getUrl();
    static Response response;
    static JSONArray expJson, actJson;
    static LinkedHashMap<String,String> params = new LinkedHashMap<>();

    private static String RESOURCE_LOCATION = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Data" + File.separator;

    public static void getSpecificResource(String id){
        url = EndPOints.ATTRACTIONS.getUrl();
        response = givenConfig().queryParam("cityId",id).log().all().when().get(url);
        System.out.println(response.prettyPeek());
    }

    // Approach 2 :- Compare the Json response with the existing JSON file. In case of any parameters change, need to update this file.
    //  This approach is fast. And we need to change the data parameterisetion from any place in case of changes

    public static JSONArray getExpectedJson(String fileName){
        return expJson = APIMethods.convertJsonFileToJsonArray(fileName, RESOURCE_LOCATION);
    }

    public static JSONArray getActualJsonResponse(){
        return actJson=APIMethods.convertApiResponseToJsonArray(response);
    }

    public static void getAllCities(){
        url = EndPOints.CITIES.getUrl();
        response = givenConfig().log().all().when().get(url);
    }

    public static List<String> compareCities(){
        JsonPath jsonPath = response.jsonPath();
        List<String>city = jsonPath.getList("title");
        System.out.println(city);
        return city;
    }

    // multiple params created using the hashmap
    public static void getCityTypeRating(String id, String attractionType, String sortField, String order){
        params.put("cityId",id);
        params.put("type",attractionType);
        params.put("_sort",sortField);
        params.put("_order",order);

        url = EndPOints.ATTRACTIONS.getUrl();
        response = givenConfig().queryParams(params).log().all().get(url);
        System.out.println(response.prettyPeek());
    }


}


