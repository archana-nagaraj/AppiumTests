package com.example.appiumtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import java.net.URL;
import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public  class firstAppiumTest {
    private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private static final String APPIUM = "http://127.0.0.1:4723/wd/hub";
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), cap);
    }

    @After
    public void tearDown() throws Exception{
        if (driver!=null)
            driver.quit();
    }

    @Test
    public void test() {
        System.out.println("Success");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Screen")));
        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Screen")));
        screen.click();
       }
}

