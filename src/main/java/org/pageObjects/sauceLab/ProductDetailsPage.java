package org.pageObjects.sauceLab;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumSelectors;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductDetailsPage {

    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add To Cart'")
    private SelenideElement addToCart;

    By productName = AppiumSelectors.withTagAndText("android.widget.TextView","Sauce Labs Backpack");

    By productPrice = AppiumSelectors.byContentDescription("product price");

    public ProductDetailsPage validateAddToCartButton(){
        try {
            $(addToCart)
                    .shouldBe(visible, Duration.ofSeconds(30));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDetailsPage validateProductName(){
        try {
            $(productName)
                    .shouldBe(visible)
                    .shouldHave(text("Backpack"));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDetailsPage validateProductValue(){
        try {
            $(productPrice)
                    .shouldBe(visible)
                    .shouldHave(text("$"));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDetailsPage clickAddToCartButton(){
        try {
            $(addToCart)
                    .shouldBe(visible, Duration.ofSeconds(30))
                    .shouldBe(clickable)
                    .click(tap());
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
