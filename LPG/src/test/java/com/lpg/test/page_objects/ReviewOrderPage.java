package com.lpg.test.page_objects;

import com.lpg.test.framework.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewOrderPage extends CommonMethods {

    public ReviewOrderPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Elements needs to be identified using CSSSelectors

    @FindBy(css = ".lc-cart__prices-number .formatted-price")
    private WebElement textOrderTotal;

    @FindBy(css = ".travel-date--datepicker")
    private WebElement inputDate;

    @FindBy(css = "img[src*='calendar']")
    private WebElement iconCalendar;

    @FindBy(css = "a[data-testid='continueToPayment']")
    private WebElement buttonContinue;

    @FindBy(css = "a[title='Next']")
    private WebElement buttonNext;

    @FindBy(css = ".ui-state-default")
    private List<WebElement> dates;

    public void enterDateAndContinue() {
        //the below code due to the system behaviour sometimes navigates to the different page
        if (!webDriver.getCurrentUrl().contains("review-your-order")) {
            webDriver.navigate().to("https://gocity.com/boston/en-us/products/all-inclusive/review-your-order");
        }
        waitTillElementVisible(inputDate).click();
        waitTillElementVisible(buttonNext).click();
        dates.get(10).click();
        waitTillElementVisible(buttonContinue).click();
    }
}
