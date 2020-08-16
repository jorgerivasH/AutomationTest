package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contain the web element in the Home page as well as some method that user can do
 * within this page*/
public class HomePage extends BasePageObject{

    private By searchGoogleLocator = By.xpath("//input[@name='q']");
    private By googleLabelLocator = By.xpath("//img[@id='hplogo']");
    private By SearchBtnLocator = By.xpath("//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    BasePageObject base=new BasePageObject(driver,log);

    public void goToHomePage(){
        log.info("Opening www.google.com page");
        base.openUrl("http://www.google.com");
        log.info("Type in Google’s search “Focus Services”");
        base.type("Focus Services",searchGoogleLocator);
        base.click(googleLabelLocator);
        log.info("Searching “Focus Services”");
        base.click(SearchBtnLocator);
    }
}
