package com.bank.testbase;

import com.bank.propertyreader.PropertyReader;
import com.bank.utilities.Utility;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

public class TestBase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
        Set<Cookie> allCookies=driver.manage().getCookies();
        for(Cookie cookie: allCookies)
        {
            driver.manage().addCookie(cookie);
        }

    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}


