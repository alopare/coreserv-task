package com.mastercard.pageobjects.basepageplatform;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * @author alopare
 */
public class CommonImpl extends BasePage {
    public CommonImpl(WebDriver driver) {
        super(driver);
    }

    private static String previousTab = null;

    public static void getWideViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(2000, 1024));
    }

    public static void getSuperWideViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(3000, 1024));
    }

    public static void getStandardViewPort(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }

    public static void getMaxViewPort(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void switchToLastTab() {
        previousTab = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> handles = s.iterator();

        while (handles.hasNext()) {
            String childTab = handles.next();
            if (!previousTab.equals(childTab)) {
                driver.switchTo().window(childTab);
            }
        }
    }

    public static void switchToParentTab() {
        if (previousTab != null) {
            driver.switchTo().window(previousTab);
        } else {
            throw new Error("No parent page initialized");
        }

    }
}
