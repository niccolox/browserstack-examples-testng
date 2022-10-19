package com.browserstack.test.suites.onboarding;

import com.browserstack.test.suites.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

public class LoginTest extends TestBase {

    @Test
    public void loginSuccess() {
        getDriver().findElement(By.id("signin")).click();
        getDriver().findElement(By.cssSelector("#username input")).sendKeys("demouser" + Keys.ENTER);
        getDriver().findElement(By.cssSelector("#password input")).sendKeys("testingisfun99" + Keys.ENTER);
        getDriver().findElement(By.id("login-btn")).click();

        Assert.assertEquals(getDriver().findElement(By.className("username")).getText(), "demouser");
    }

    private boolean downloadedFileExists(String fileName) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        return Boolean.parseBoolean(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"" + fileName + "\"}}").toString());
    }

}