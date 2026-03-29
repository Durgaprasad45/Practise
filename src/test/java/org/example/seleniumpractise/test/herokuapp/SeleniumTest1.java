package org.example.seleniumpractise.test.herokuapp;

import org.example.seleniumpractise.pages.BasePage;
import org.example.seleniumpractise.pages.HerokuappBasePage;
import org.example.utilities.ConfigHelper;
import org.testng.annotations.Test;

public class SeleniumTest1 extends BasePage {

    @Test(enabled = false)
    public void abTestingClick(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.isABTestingElementDisplayed();
    }

    @Test
    public void addRemoveElementTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.clickOnAddRemoveElementLink();
    }

    @Test
    public void contextClickTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.contextMenuRightClick();
    }

    @Test
    public void dragAndDropTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.dragAndDropScenario();
    }

    @Test
    public void dropdownTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.selectDropdownTest("Dropdown");
    }

    @Test
    public void dynamicElementsTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.dynamicElements("Dynamic Controls");
    }

    @Test
    public void dynamicLoadingTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.dynamicLoading("Dynamic Loading");
    }

    @Test
    public void fileUploadTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.fileUpload("File Upload");
        System.out.println(ConfigHelper.getProperty("A"));
    }

    @Test
    public void frameHandlingTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.frameHandling("Frames");
    }

    @Test
    public void geoLocationTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.geoLocationHandling("Geolocation");
    }

    @Test
    public void horizontalSlidingTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.horizontalSlider("Horizontal Slider");
    }

    @Test
    public void hoverOverTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.hoverOver("Hovers");
    }

    @Test
    public void jQueryTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.jquery("JQuery UI Menus");
    }

    @Test
    public void alertsTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.workingWithAlerts("JavaScript Alerts");
    }


    @Test
    public void workWithKeysTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.workWithKeys("Key Presses");
    }

    @Test
    public void workWithWindowTest(){
        HerokuappBasePage herokuappBasePage = new HerokuappBasePage(driver);
        herokuappBasePage.windowsSwitch("Multiple Windows");
    }
}
