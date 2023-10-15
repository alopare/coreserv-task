package com.mastercard.testplatform;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.mastercard.pageobjects.basepageplatform.CommonImpl.getMaxViewPort;

/**
 * @author alopare
 */
public class BTest {
    public static final String localPropertiesPath = System.getProperty("user.dir") + "/default.properties";
    public static WebDriver driver = null;
    public static Logger logger = null;
    private static String browser;

    private String url;
    private FileInputStream f;
    protected static Properties prop;


    @BeforeSuite
    public void baseSetUp() throws IOException {
        prop = new Properties();
        f = new FileInputStream(localPropertiesPath);
        prop.load(f);
        url = prop.getProperty("basePageUrl");
        browser = prop.getProperty("browser");

        if (driver == null) {
            this.driver = WebDriverFactory.getDriver(browser.toLowerCase());
        }

        getMaxViewPort(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @BeforeClass
    public void beforeClassBaseSetUp() {
        logger = Logger.getLogger("MasterCardTest-->  ");
        logger.setLevel(Level.DEBUG);
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterSuite
    public void afterSuitePerformed() {
        driver.quit();
        driver = null;
    }
}

