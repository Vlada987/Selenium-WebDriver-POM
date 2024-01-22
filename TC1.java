package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC1 extends BaseTest {

public LoginPage logp;
public HomePage homp;

@Test
public void tc1(){
    logp = new LoginPage(driver);
    logp.openPage();
    logp.login("standard_user", "secret_sauce");
    logp.checkWindowTitle("Swag Labs");
    homp = new HomePage(driver);
    homp.checkHomePageTitle("Products");
    homp.filterButtonPresence(true);
    homp.filterFromMostExpencive();
    homp.filterCheck(true);
 }
}
