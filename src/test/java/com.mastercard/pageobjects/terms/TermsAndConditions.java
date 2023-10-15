package com.mastercard.pageobjects.terms;

import com.mastercard.pageobjects.basepageplatform.CommonImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author alopare
 */

public class TermsAndConditions extends CommonImpl {
    private final By aprForCashAdvances = By.xpath("//td[b[text()='APR for Cash Advances']]//following-sibling::td/b");

    public TermsAndConditions(WebDriver driver) {
        super(driver);
    }

    public Double getAprValue() {
        String apr = this.getTextAsString(aprForCashAdvances);
        String percentage = apr.split("%")[0];
        return Double.parseDouble(percentage);
    }
}
