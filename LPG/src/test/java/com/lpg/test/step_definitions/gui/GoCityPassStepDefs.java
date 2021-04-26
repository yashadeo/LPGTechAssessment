package com.lpg.test.step_definitions.gui;

import com.lpg.test.framework.helpers.UrlBuilder;
import com.lpg.test.page_objects.AllInclusivePage;
import com.lpg.test.page_objects.PaymentPage;
import com.lpg.test.page_objects.ReviewOrderPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoCityPassStepDefs {
    private AllInclusivePage allInclusivePage;
    private PaymentPage paymentPage;
    private ReviewOrderPage reviewOrderPage;

    List<String>calendarVals = new ArrayList<>();

    public GoCityPassStepDefs(AllInclusivePage allInclusivePage, PaymentPage paymentPage, ReviewOrderPage reviewOrderPage) throws IOException {
        this.reviewOrderPage = reviewOrderPage;
        this.paymentPage = paymentPage;
        this.allInclusivePage = allInclusivePage;
    }

    @Given("^I navigate to the Project \"([^\"]*)\" page$")
    public void iNavigateToTheProjectPage(String page) throws Throwable {
        if (page.equalsIgnoreCase("Home"))
            UrlBuilder.startAtHomePage();
    }

    @When("^the user selects the dropdown option as \"([^\"]*)\"$")
    public void the_user_selects_the_dropdown_option_as(String passForDays) throws Throwable {
        allInclusivePage.selectDayPassValue(passForDays);
    }

    @When("^press checkout button$")
    public void press_checkout_button() throws Throwable {
        allInclusivePage.pressCheckout();
    }

    @When("^enters the date and presses Continue button$")
    public void enters_the_date_and_presses_Continue_button() throws Throwable {
        reviewOrderPage.enterDateAndContinue();
    }

    @When("^enter email \"([^\"]*)\",$")
    public void enter_email(String email) throws Throwable {
        paymentPage.enterEmail(email);
    }

    @When("^enter card details as card number \"([^\"]*)\", month \"([^\"]*)\", year \"([^\"]*)\", Code \"([^\"]*)\"$")
    public void enter_card_details_as_card_number_month_year_Code(String number, String month, String years, String code) throws Throwable {
        paymentPage.enterCardNumber(number,month,years,code);
    }


    @When("^enter billing address \"([^\"]*)\", city \"([^\"]*)\", zip \"([^\"]*)\", country \"([^\"]*)\", state \"([^\"]*)\"$")
    public void enter_billing_address_city_zip_country_state(String street, String city, String zip, String country, String state) throws Throwable {
        paymentPage.enterBillingAddress(street,city,zip, country,state);
    }

    @When("^enters personal details as name \"([^\"]*)\", last name \"([^\"]*)\" and phone \"([^\"]*)\"$")
    public void enters_personal_details_as_name_last_name_and_phone(String name, String surname, String phone) throws Throwable {
        String phonenum = phone.replaceAll("[^\\d.]", "");
        paymentPage.enterPersonalDetails(name,surname,phonenum);
    }

    @When("^press Confirm Order button$")
    public void press_Confirm_Order_button() throws Throwable {
        paymentPage.confirmOrder();
    }

    @Then("^the user should see the \"([^\"]*)\" message$")
    public void the_user_should_see_the_message(String error) throws Throwable {
        Assert.assertEquals(paymentPage.getPaymentFailureMessage(),error);
    }

}
