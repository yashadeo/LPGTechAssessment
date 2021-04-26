package com.lpg.test.page_objects;

import com.lpg.test.framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllInclusivePage extends CommonMethods {

    public AllInclusivePage() {
        PageFactory.initElements(webDriver, this);
    }

    //Elements needs to be identified using CSSSelectors

    @FindBy(css = "select[class='form-control']")
    private WebElement dropDownFormControl;

    @FindBy(css = "select[class='form-control'] option")
    private List<WebElement> option;

    @FindBy(css = "div[class='lc-cart__item-amount-plus']")
    private List<WebElement> incrementCounter;

    @FindBy(css = "div[class='cart-icon__icon-counter']")
    private WebElement iconBasketValue;

    @FindBy(css = ".cart-icon__icon-counter")
    private WebElement iconContainer;

    @FindBy(css = "a[href*='review-your-order']")
    private WebElement buttonCheckout;

    @FindBy(css = "div[class='lc-cart__prices-discount'] .formatted-price")
    private WebElement textSaleDiscount;

    @FindBy(css = "div[class='lc-cart__prices-total lc-font__regular'] .formatted-price")
    private WebElement textOrderTotal;

    @FindBy(className = "slide-in--actions--close")
    private WebElement popUp;

    @FindBy(css = "a[href*='pricing']")
    private List<WebElement> buttonBuy;

    @FindBy(css = "button[class='btn lc-products-list__item-select lc-font__regular']")
    private List<WebElement> selectPass;

    int adultQuantity,  childQuantity;

    // ideally the passed string parameter should be used to form the element identofier
    public void selectDayPassValue(String dayPassOption) throws InterruptedException {
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        waitTillElementVisible(buttonBuy.get(1)).click();
        //Thread.sleep is not a good practice but at the moment, sometimes, the worong page displays, so to avoid that jave used it
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[contains(text(),'Best choice')]")).click();
        Thread.sleep(2000);

    }

    public void pressCheckout(){
        waitTillElementVisible(buttonCheckout).click();
    }

}