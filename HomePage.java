package pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);    
    }
    
    By homePageTitle = By.xpath("//span[@class='title']");
    By filterButton = By.xpath("//select[@class='product_sort_container']");

    public HomePage checkHomePageTitle(String txt){
        String homePageTitleTxtAct = readText(homePageTitle);
        compareText(txt, homePageTitleTxtAct);
        return this;
    }
    public HomePage filterButtonPresence(Boolean bEXP){
        Boolean bACT = isItPresentMain(filterButton);
        compareBoolean(bEXP, bACT);
        return this;
    }
    public HomePage filterFromMostExpencive(){
        WebElement filterButtonWE = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select ss1 = new Select(filterButtonWE);
        ss1.selectByIndex(3);
        return this;
    }  
    public Boolean filterTakePricesAndCompare(){
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> pricesTxt = new ArrayList<>();
        List<Double> pricesDbl = new ArrayList<>();
        for(WebElement p:products){
        pricesTxt.add(p.getText());
        }
        for(String price: pricesTxt) { 
        pricesDbl.add(Double.valueOf(price.replace("$", "")));
        }
        Double price1 = pricesDbl.get(0);
        Double price2 = pricesDbl.get(1);
        Double price3 = pricesDbl.get(2);
        Double price4 = pricesDbl.get(3);
        Double price5 = pricesDbl.get(4);
        Double price6 = pricesDbl.get(5);
        
        if(price1>=price2 && price2>=price3 && price3>=price4 && price4>=price5 && price5>=price6){
            return true;
        }   
        else{
            return false;
        }   
     }
    

    public HomePage filterCheck(Boolean bEx){
        Boolean bAc = filterTakePricesAndCompare();
        compareBoolean(bEx, bAc);
        return this;
    }
        
}
