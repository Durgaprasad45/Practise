package org.example.seleniumpractise.test.herokuapp;

import org.example.seleniumpractise.pages.BasePage;
import org.example.seleniumpractise.pages.HerokuappBasePage;
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

}
