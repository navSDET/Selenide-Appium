package org.pageObjects.sauceLab;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumSelectors;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ShoppingBagPage {

    ProductDetailsPage productDetailsPage;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
//    private SelenideElement cartCount;

    By cartCount= AppiumSelectors.byAttribute("class","android.widget.TextView");

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView\n")
    private SelenideElement addProductOnPDP;

    public ShoppingBagPage validateCartCount(){
        productDetailsPage = ScreenObject.screen(ProductDetailsPage.class);
        $(cartCount)
                .shouldBe(visible)
                .shouldHave(text("1"));

        $(addProductOnPDP)
                .shouldBe(visible)
                .click();

        productDetailsPage.clickAddToCartButton();

        $(cartCount)
                .shouldBe(visible)
                .shouldHave(text("3"));

        return this;
    }



}
