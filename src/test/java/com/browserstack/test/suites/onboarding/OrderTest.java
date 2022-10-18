package com.browserstack.test.suites.onboarding;

import com.browserstack.app.pages.ConfirmationPage;
import com.browserstack.app.pages.HomePage;
import com.browserstack.app.pages.OrdersPage;
import com.browserstack.test.suites.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrderTest extends TestBase {

    @Test
    public void placeOrder() {
        SoftAssert softly = new SoftAssert();
        ConfirmationPage page = new HomePage(getDriver())
                .navigateToSignIn()
                .loginWith("demouser", "testingisfun99")
                .addProductToCart("iPhone 12")
                .getBag().waitForItemsInBag(1)
                .getBag().proceedToCheckout()
                .enterShippingDetails("firstname", "lastname", "address", "state", "12345");
        Assert.assertTrue(page.isConfirmationDisplayed());

        OrdersPage ordersPage = page.continueShopping().navigateToOrders();

        softly.assertEquals(ordersPage.getItemsFromOrder(), 1);
        softly.assertAll();
    }

}