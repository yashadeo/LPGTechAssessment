package com.lpg.test.step_definitions.api;

import com.lpg.test.framework.helpers.APIMethods;
import com.lpg.test.services.ReqResAPI;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ReqResSteps {

    private Response response;

    @When("^user sends the get request to fetch all the attaractions for the city \"([^\"]*)\" and id \"([^\"]*)\"$")
    public void user_sends_the_get_request_to_fetch_all_the_attaractions_for_the_city_and_id(String city, String id) throws Throwable {
       ReqResAPI.getSpecificResource(id);
    }

    @Then("^user should see all the all the attractions for the city and the file should match with the \"([^\"]*)\"$")
    public void user_should_see_all_the_all_the_attractions_for_the_city_and_the_file_should_match_with_the(String fileName) throws Throwable {
        Assert.assertEquals(ReqResAPI.getExpectedJson(fileName),ReqResAPI.getActualJsonResponse());
    }

    @Then("^user should see all the all the attractions for the city$")
    public void user_should_see_all_the_all_the_attractions_for_the_city() throws Throwable {

    }

    @When("^user sends the get request to fetch all the cities$")
    public void user_sends_the_get_request_to_fetch_all_the_cities() throws Throwable {
        ReqResAPI.getAllCities();
    }

    @Then("^user should see all the cities as below present in the responses$")
    public void user_should_see_all_the_cities_as_below_present_in_the_responses(List<String> cityNames) throws Throwable {
        Assert.assertEquals(ReqResAPI.compareCities(),cityNames);
    }


    @Then("^user should see all the cities as below present in the response$")
    public void user_should_see_all_the_cities_as_below_present_in_the_response(List<String> cities) throws Throwable {

    }

    @When("^user sends the request to fetch the resources for the the city \"([^\"]*)\", id \"([^\"]*)\", type as \"([^\"]*)\", field to sort ad \"([^\"]*)\"  and order \"([^\"]*)\"$")
    public void user_sends_the_request_to_fetch_the_resources_for_the_the_city_id_type_as_field_to_sort_ad_and_order(String city, String id, String attractionType, String sortField, String order) throws Throwable {
        ReqResAPI.getCityTypeRating(id,attractionType,sortField,order);
    }

    @Then("^user should see the response only for the given criteria$")
    public void user_should_see_the_response_only_for_the_given_criteria() throws Throwable {

    }


}
