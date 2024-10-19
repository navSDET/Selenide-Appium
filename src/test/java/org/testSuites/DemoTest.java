package org.testSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.ScreenObject;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.pageObjects.sauceLab.ShoppingBagPage;
import org.pageObjects.sauceLab.HomePage;
import org.pageObjects.sauceLab.ProductDetailsPage;
import org.providers.sauceLabiOSAppProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.*;

public class DemoTest {
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    ShoppingBagPage shoppingBagPage;

    @Test
    public void androidLaunchTest() {
        //below commented code is handled in selenide.properties file as a key: selenide.browser
//        Configuration.browser= sauceLabAndroidAppProvider.class.getName();
        SelenideAppium.launchApp();

        $(AppiumBy.accessibilityId("open menu"))
                .shouldBe(visible)
                .click();

        WebDriverRunner.driver().close();
    }

    @Test
    public void validateAddToBag() {
        SelenideAppium.launchApp();
        homePage = ScreenObject.screen(HomePage.class);
        productDetailsPage = ScreenObject.screen(ProductDetailsPage.class);

        homePage.clickProduct();
        productDetailsPage
                .validateAddToCartButton()
                .clickAddToCartButton();
    }

    @Test
    public void validateCartQuantity(){
        SelenideAppium.launchApp();
        shoppingBagPage = ScreenObject.screen(ShoppingBagPage.class);

        shoppingBagPage.validateCartCount();


    }

//    @Test
    public void iOSLaunchTest() {
        Configuration.browser= sauceLabiOSAppProvider.class.getName();
        SelenideAppium.launchApp();
        $$(By.name("store item text")).get(0).click();
    }


}
