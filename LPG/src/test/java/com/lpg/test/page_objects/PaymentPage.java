package com.lpg.test.page_objects;

import com.lpg.test.framework.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class PaymentPage extends CommonMethods {

    public PaymentPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Elements needs to be identified using CSSSelectors

    @FindBy(css = ".lc-cart__prices-number .formatted-price")
    private WebElement textOrderTotal;

    @FindBy(css = "#checkout-form-email")
    WebElement email;

    @FindBy(css = "#credit-card-number")
    private WebElement cardNumber;

    @FindBy(css = "input[id='expiration-month']")
    private WebElement expirationMonth;

    @FindBy(css = "input[id='expiration-year']")
    private WebElement expirationYear;

    @FindBy(css="input[placeholder='Security code*']")
    private WebElement securityCode;

    @FindBy(css = "#checkout-form-first-name")
    private WebElement firstName;

    @FindBy(css = "#checkout-form-last-name")
    private WebElement lastName;

    @FindBy(css = "#checkout-form-phone-number")
    private WebElement phoneNumber;

    @FindBy(css = ".checkout-form__address-finder-manually")
    private WebElement billingAddress;

    @FindBy(css = "#checkout-form-terms")
    private WebElement IAgreeCheckBox;

    @FindBy(css = "span[data-testid='confirmOrderAndPay']")
    private WebElement buttonConfirm;

    @FindBy(css = "#braintree-hosted-field-number")
    private WebElement iframePayment;

    @FindBy(css = "#braintree-hosted-field-expirationMonth")
    private WebElement iframeMonth;

    @FindBy(css = "#braintree-hosted-field-expirationYear")
    private WebElement iframeYear;

    @FindBy(css = "#braintree-hosted-field-cvv")
    private WebElement iframeCVV;

    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement errorMSG;

    @FindBy(css = "#checkout-form-street")
    private WebElement street;

    @FindBy(css = "#checkout-form-city")
    private WebElement city;

    @FindBy(css = "#checkout-form-zipcode")
    private WebElement zip;

    @FindBy(css = "#checkout-form-country")
    private WebElement country;

    @FindBy(css = "#checkout-form-country option")
    private List<WebElement> countryOptions;

    @FindBy(css = "#checkout-form-state")
    private WebElement state;

    @FindBy(css = "#checkout-form-state option")
    private List<WebElement> stateOption;

    public void enterEmail(String emails){
        email.sendKeys(emails);
    }

    public void enterCardNumber(String cardNumbers, String months, String years, String codes){
        webDriver.switchTo().frame(iframePayment);
        cardNumber.sendKeys(cardNumbers);
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(iframeMonth);
        expirationMonth.sendKeys(months);
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(iframeYear);
        expirationYear.sendKeys(years);
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(iframeCVV);
        securityCode.sendKeys(codes);
        webDriver.switchTo().defaultContent();
    }

    public void enterPersonalDetails(String name, String surname, String phone){
        waitTillElementVisible(firstName).sendKeys(name);
        waitTillElementVisible(lastName).sendKeys(surname);
        waitTillElementVisible(phoneNumber).clear();
        waitTillElementVisible(phoneNumber).sendKeys(phone);
    }

    public void enterBillingAddress(String streets, String cities, String zipCode, String countries, String states){
        billingAddress.click();
        waitTillElementVisible(street).sendKeys(streets);
        city.sendKeys(cities);
        country.click();
        selectValueFromList(countryOptions,countries).click();
        zip.sendKeys(zipCode);
        state.click();
        selectValueFromList(stateOption,states).click();
    }

    public void confirmOrder(){
        clickUsingJS(IAgreeCheckBox);
        waitTillElementVisible(buttonConfirm).click();
    }

    public String getPaymentFailureMessage(){
        return waitTillElementVisible(errorMSG).getText();
    }
}