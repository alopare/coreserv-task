package com.mastercard.tests;

import com.mastercard.pageobjects.info.InfoPage;
import com.mastercard.pageobjects.terms.TermsAndConditions;
import com.mastercard.testplatform.BTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author alopare
 */
public class MasterCardTest extends BTest {
    private InfoPage infoPage = null;

    @BeforeClass
    public void setUpTest() {
        infoPage = new InfoPage(driver);
    }

    @Parameters({"apr"})
    @Test
    public void aprValidationTest(String apr) {
        BTest.logger.info(this.getClass() + "--> Clicking on Business Cards");
        BTest.logger.info(this.getClass() + "--> Selecting terms for Mastercard Business Platinum Rewards");
        TermsAndConditions terms = infoPage.clickViewBusinessCard().clickPlatinumRewardsTerms();
        BTest.logger.info(this.getClass() + "--> Getting current APR value");
        Double currentApr = terms.getAprValue();
        BTest.logger.info(this.getClass() + "--> Comparing current APR value with expected");
        assertTrue(currentApr < Double.parseDouble((apr)), "Current APR is greater than " + apr);
    }
}
