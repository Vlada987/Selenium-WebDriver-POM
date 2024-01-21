package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);      
    }

    String baseURI = "https://www.saucedemo.com/";
    By userName = By.id("user-name");
    By passWord = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage openPage(){
        driver.get(baseURI);
        return this;
    }
    public LoginPage login(String userNameTxt, String pasSwordTxt){
        writeText(userName, userNameTxt);
        writeText(passWord, pasSwordTxt);
        clickButton(loginButton);
        return this;
    }
    public LoginPage checkWindowTitle(String WindowTitleExp){
        String WindowTitleACT = getWindowTitle();
        compareText(WindowTitleExp, WindowTitleACT);
        return this;
    }

   
    



      }
    

    
