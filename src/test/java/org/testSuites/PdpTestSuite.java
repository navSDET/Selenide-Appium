package org.testSuites;

import org.testng.annotations.Test;
import org.tests.ProductDetails;

public class PdpTestSuite {

    @Test(alwaysRun = true, testName = "Validate user is navigated to PDP after selecting 1st available product on PLP",
            groups = { "PdpTest", "Regression", "Sanity"}, description = "SA-5005")
    public void validateProductDetailsPageIsDisplayed () {
        ProductDetails productDetails = new ProductDetails();
        productDetails.validateProductDetailsPageIsDisplayed();
    }

}
