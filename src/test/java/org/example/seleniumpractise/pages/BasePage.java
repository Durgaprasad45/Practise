package org.example.seleniumpractise.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.seleniumpractise.drivermanagement.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {

    protected WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = DriverClass.init();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
       DriverClass.quitDriver();
    }
}
