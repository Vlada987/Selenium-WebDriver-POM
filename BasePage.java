package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

public WebDriver driver; 
public WebDriverWait wait;


public BasePage(WebDriver driver){
    this.driver=driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
}
public void writeText(By element, String text){
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    driver.findElement(element).sendKeys(text);    
}
public void clickButton(By element){
    wait.until(ExpectedConditions.elementToBeClickable(element));
    driver.findElement(element).click();
}
public String getWindowTitle(){
    return driver.getTitle();
}
public String readText(By element){
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    return driver.findElement(element).getText();

}
public void compareText(String txt1, String txt2){
    Assert.assertEquals(txt1, txt2);
}
public Boolean isItPresentMain(By element){
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    return driver.findElement(element).isDisplayed();
}
public void compareBoolean(Boolean b1, Boolean b2){
    Assert.assertEquals(b1, b2);
}

}
