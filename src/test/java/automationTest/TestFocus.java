package automationTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BasePageObject;


public class TestFocus extends BaseTest {
    @Test
    public void focusTest(){
        log.info("Opening www.google.com page");
        BasePageObject base=new BasePageObject(driver,log);
        base.openUrl("http://www.google.com");

        log.info("Type in Google’s search “Focus Services”");



    }

}
