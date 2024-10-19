package org.pageObjects.sauceLab;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumSelectors;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"store item\"]")
    @iOSXCUITFindBy(xpath = "//*[@name='store item text']")
    private SelenideElement product1;

    By by1= AppiumSelectors.byAttribute("content-desc","store item");
    By by2= AppiumSelectors.withAttribute("content-desc","store i");
    By by3= AppiumSelectors.byContentDescription("store item");
    By by4= AppiumSelectors.byContentDescription("store it");
    By by5= AppiumSelectors.byTagAndContentDescription("android.view.ViewGroup","store item");
    By by6= AppiumSelectors.byAttribute("name","store item text");
//    CombinedBy product1 = CombinedBy.android(by1).ios(by6);

    public HomePage clickProduct(){
        $(product1)
                .shouldBe(visible, Duration.ofSeconds(30))
                .shouldBe(clickable)
                .click(tap());
        return this;
    }



}
