package com.mastercard.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * @author alopare
 */
public class DataProviders {
    @DataProvider(name = "cards")
    public Object[][] portsProvider() throws IOException {
        return new Object[0][0];
    }
}