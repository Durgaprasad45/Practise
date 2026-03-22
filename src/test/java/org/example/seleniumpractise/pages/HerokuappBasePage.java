package org.example.seleniumpractise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HerokuappBasePage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "//ul/li/a[contains(text(),'A/B Testing')]")
    public WebElement abTestingElement;

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement abTestingText;

    @FindBy(xpath = "//ul/li/a[contains(text(),'Add/Remove Elements')]")
    public WebElement addRemoveElementsLink;

    public HerokuappBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void isABTestingElementDisplayed(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.elementToBeClickable(abTestingElement));
        abTestingElement.click();
        System.out.println("Text ===:=== "+ abTestingText.getText());
    }

    public void clickOnAddRemoveElementLink(){
        addRemoveElementsLink.click();
        driver.findElement(By.xpath("//div[@id='content']/h3")).isDisplayed();
        for(int i=0;i<4;i++)
            driver.findElement(By.xpath("//div/button[contains(text(),'Add Element')]")).click();
        int size = driver.findElements(By.xpath("//div/button[@class='added-manually']")).size();
        System.out.println("Size : ==="+ size);
        for(int i=0;i<size;i++){
            driver.findElement(By.xpath("//div/button[@class='added-manually']")).click();
        }
    }

    //contextclick(rightclick)
    public void contextMenuRightClick(){
        driver.findElement(By.xpath("//ul/li/a[contains(text(),'Context Menu')]")).click();
        WebElement contextClick = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        new Actions(driver).contextClick(contextClick).perform();
        Alert alert = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println("Text ----- "+text);
        alert.accept();
    }

    //drag and drop
    public void dragAndDropScenario(){
        driver.findElement(By.xpath("//ul/li/a[contains(text(),'Drag and Drop')]")).click();
        WebElement draggable = driver.findElement(By.id("column-a"));
        WebElement dropable = driver.findElement(By.id("column-b"));
        new Actions(driver).dragAndDrop(draggable,dropable).perform();
    }

}
