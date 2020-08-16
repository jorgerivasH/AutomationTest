package automationTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;


public class TestFocus extends BaseTest {
    @Test
    public void focusTest() throws InterruptedException {

        HomePage home = new HomePage(driver,log);
        home.goToHomePage();
        Thread.sleep(10000);
    }

}
