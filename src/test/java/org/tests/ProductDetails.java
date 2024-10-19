package org.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.ScreenObject;
import com.codeborne.selenide.appium.SelenideAppium;
import org.pageObjects.sauceLab.HomePage;
import org.pageObjects.sauceLab.ProductDetailsPage;

public class ProductDetails {
    HomePage homePage;
    ProductDetailsPage productDetails;

    public ProductDetails validateProductDetailsPageIsDisplayed(){
        SelenideAppium.launchApp();
        homePage = ScreenObject.screen(HomePage.class);
        productDetails = ScreenObject.screen(ProductDetailsPage.class);

        homePage
                .clickProduct();
        productDetails
                .validateAddToCartButton()
                .validateProductName()
                .validateProductValue();


        WebDriverRunner.driver().close();
        return this;
    }
}
