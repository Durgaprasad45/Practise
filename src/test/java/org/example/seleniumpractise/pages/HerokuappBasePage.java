package org.example.seleniumpractise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void clickOnElement(String element){
        driver.findElement(By.xpath(String.format("//ul/li/a[contains(text(),'%s')]",element))).click();
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

    //dropdown
    public void selectDropdownTest(String element){
        clickOnElement(element);
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByValue("1");
    }

    public void dynamicElements(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(
                NoSuchElementException.class);
        WebElement element1 = wait.until(driver -> driver.findElement(By.xpath("//p[@id='message']")));
        System.out.println(element1.getText());
    }

    public void dynamicLoading(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//div/p//following-sibling::a[1]")).click();
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(5));
        By startXpath = By.xpath("//div[@id='start']//button");
        System.out.println(wait.until(driver1 -> driver1.findElement(startXpath)).isDisplayed());
        driver.findElement(startXpath).click();
        By helloWorldElement = By.xpath("//div[@id='finish']/h4");
        System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(helloWorldElement))).isDisplayed());
        System.out.println("Text : "+ driver.findElement(helloWorldElement).getText());
    }


    public void fileUpload(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Durgaprasad_Cheerla\\intellij-projects\\AutomationPractise\\src\\test\\resources\\ActAsTeam.png");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
    }

    public void frameHandling(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
        System.out.println("Switching to Top Frame");
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        System.out.println("Switching to Left Frame");
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        System.out.println("Get text from Left Frame");
        WebElement leftFrameText = driver.findElement(By.xpath("//body[normalize-space() = 'LEFT']"));
        System.out.println(leftFrameText.getText());
        System.out.println("Switching to default content(main page)");
        driver.switchTo().defaultContent();
        System.out.println("Switching to Bottom Frame");
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomFrame);
        System.out.println("Get text from Bottom Frame:");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

    public void geoLocationHandling(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//p/following-sibling::button")).click();
    }

    public void horizontalSlider(String element){
        clickOnElement(element);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
//        new Actions(driver).clickAndHold(slider).moveByOffset(10,0).release().perform();

//        slider.sendKeys(Keys.ARROW_RIGHT);
//        slider.sendKeys(Keys.ARROW_RIGHT);
//        slider.sendKeys(Keys.ARROW_RIGHT);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='4'; arguments[0].dispatchEvent(new Event('change'));", slider);
    }

    public void hoverOver(String element){
        clickOnElement(element);
        WebElement hoverImg = driver.findElement(By.xpath("//div[1]/img"));
        new Actions(driver).moveToElement(hoverImg).perform();
        WebElement viewResult = driver.findElement(By.xpath("//h5[text() = 'name: user1']/following-sibling::a"));
        viewResult.click();
    }

    public void jquery(String element){
        clickOnElement(element);
        By enabled = By.xpath("//a[normalize-space()='Enabled']");
        new Actions(driver).moveToElement(driver.findElement(enabled)).perform();
        WebElement backToJquery = driver.findElement(By.xpath("//a[normalize-space()='Back to JQuery UI']"));
//        new Actions(driver).moveToElement(driver.findElement(backToJquery)).click(driver.findElement(backToJquery)).perform();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",backToJquery);
    }

    public void workingWithAlerts(String element){
        clickOnElement(element);
        Alert alert;
        WebElement element1 = driver.findElement(By.xpath("//li[1]/button"));
        element1.click();
        alert = driver.switchTo().alert();
        alert.accept();
        WebElement element2 = driver.findElement(By.xpath("//li[2]/button"));
        element2.click();
        alert.dismiss();
        WebElement element3 = driver.findElement(By.xpath("//li[3]/button"));
        element3.click();
        alert.sendKeys("hello");
        alert.accept();
    }

    public void workWithKeys(String element){
        clickOnElement(element);
        new Actions(driver).keyDown(Keys.SPACE).sendKeys("a").build().perform();
    }

    public void windowsSwitch(String element){
        clickOnElement(element);
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        windows.stream().forEach(System.out::println);
        for(String str : windows){
            System.out.println(str);
            if(!driver.getWindowHandle().equalsIgnoreCase(str)){
                driver.switchTo().window(str);
            }
        }
    }


}
