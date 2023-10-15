package com.mastercard.pageobjects.info;

import com.mastercard.pageobjects.basepageplatform.BasePage;
import com.mastercard.pageobjects.basepageplatform.CommonImpl;
import com.mastercard.pageobjects.terms.TermsAndConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author alopare
 */
public class InfoPage extends CommonImpl {
    private final By viewBusinessCard = By.xpath("//div[@class='productSelector_category_business']");
    private final By platinumRewardsTerms = By.xpath("//div[div[span[text()=' Business Platinum Rewards']]]//div[@class='productSelector_cardRow_applyTCContainer_tc applyTermsAndConditions']");

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    public InfoPage clickViewBusinessCard() {
        this.getElementByLocator(viewBusinessCard).click();
        return this;
    }

    public TermsAndConditions clickPlatinumRewardsTerms() {
        scrollDownTo(platinumRewardsTerms);
        this.clickElement(platinumRewardsTerms);
        switchToLastTab();
        return new TermsAndConditions(driver);
    }
}
