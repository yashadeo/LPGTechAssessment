package com.lpg.test.framework.helpers.screenshot_helper;

import com.lpg.test.framework.helpers.WebDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotHook {

    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);


   @After
    public void embedScreenshot(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                scenario.write(WebDriverHelper.getWebDriver().getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            }

        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        } finally {
            WebDriverHelper.getWebDriver().switchTo().defaultContent();
        }
    }
}
