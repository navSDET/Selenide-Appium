package org.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.providers.sauceLabAndroidAppProvider;
import org.providers.sauceLabiOSAppProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class DemoTest {

    @Test
    public void androidLaunchTest() {
        Configuration.browser=sauceLabAndroidAppProvider.class.getName();
        SelenideAppium.launchApp();
        $(AppiumBy.accessibilityId("open menu")).click();
    }

    @Test
    public void iOSLaunchTest() {
        Configuration.browser= sauceLabiOSAppProvider.class.getName();
        SelenideAppium.launchApp();
        $$(By.name("store item text")).get(0).click();
    }


}
