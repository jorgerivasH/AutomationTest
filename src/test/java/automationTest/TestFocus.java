package automationTest;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.HomePage;


public class TestFocus extends TestUtilities {


    @Test
    public void focusTest(){
        HomePage home = new HomePage(driver,log);
        home.goToHomePage();
        home.validateTextInf("www.focusservices.com");
        home.clickLinkPage();
        scrollDown();
        sleep(5000);
    }

}
