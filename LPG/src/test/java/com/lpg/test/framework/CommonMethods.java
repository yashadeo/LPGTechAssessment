package com.lpg.test.framework;

import com.lpg.test.framework.helpers.WebDriverHelper;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public abstract class CommonMethods {
    private static final long DRIVER_WAIT_TIME = 20;
    private static final Logger LOG = LoggerFactory.getLogger(CommonMethods.class);


    @Getter
    protected WebDriverWait wait;
    @Getter
    protected WebDriver webDriver;


    protected CommonMethods() {
        this.webDriver = WebDriverHelper.getWebDriver();
        this.wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
    }

    public void moveToElement(WebElement element) throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
    }

    public void scrollToView(WebElement element) {
        if (webDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        }
    }


    public WebElement waitTillElementVisible(WebElement element)  {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickUsingJS(WebElement element){

        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    public boolean textToBePresentInElementValue( WebElement element,  String text) {
        return new WebDriverWait(getWebDriver(), DRIVER_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public boolean elementToBeSelected( WebElement element) {
        return (new WebDriverWait(getWebDriver(), DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeSelected(element));
    }
    public List<WebElement> visibilityOfAllElements( List<WebElement> elements) {
        return (new WebDriverWait(getWebDriver(), DRIVER_WAIT_TIME)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement selectValueFromList(List<WebElement>elements,String stringName) {
        for(WebElement element:elements){
            if(element.getText().contains(stringName)){
                return element;
            }
        }
        return null;
    }


}