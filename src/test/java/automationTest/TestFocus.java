package automationTest;

import base.BaseTest;
import org.testng.annotations.Test;


public class TestFocus extends BaseTest {
    @Test
    public void focusTest() throws InterruptedException {
        driver.get("http://www.google.com");
        Thread.sleep(10000);
        log.info("Testing log");
    }

}
