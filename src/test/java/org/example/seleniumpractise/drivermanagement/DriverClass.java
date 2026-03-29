package org.example.seleniumpractise.drivermanagement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

public class DriverClass {
    private static ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public static WebDriver init(){
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        options.setExperimentalOption("prefs", prefs);
//        options.addArguments("--disable-geolocation");
        driver.set(new ChromeDriver(options));
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}
