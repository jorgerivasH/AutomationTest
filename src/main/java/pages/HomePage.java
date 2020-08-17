package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * This class contain the web elements located on the Home page as well as some actions
 * performed on this page
 * */
public class HomePage extends BasePageObject{

    String sourcePage=null;
    String text="";
    private By searchGoogleLocator = By.xpath("//input[@name='q']");
    private By googleLabelLocator = By.xpath("//img[@id='hplogo']");
    private By SearchBtnLocator = By.xpath("//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]");
    private By focusSerLnkLocator = By.xpath("//h3[text()='Focus Services – Beyond Expectations']");
    private By nowHiringBtnLocator = By.xpath("//span[text()='Now Hiring!']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void goToHomePage(){
        log.info("Opening www.google.com page");
        openUrl("http://www.google.com");
        log.info("Type in Google’s search “Focus Services”");
        type("Focus Services",searchGoogleLocator);
        click(googleLabelLocator);
        log.info("Searching “Focus Services”");
        click(SearchBtnLocator);
        log.info("Clicking on “Search button”");
    }

    public void validateTextInf(String text){
        sourcePage=driver.getPageSource();
        Assert.assertTrue(sourcePage.contains("www.focusservices.com"),
                "www.focusservices.com URL was not found");
        log.info("'"+text+"'"+" was found in the source page");
    }

    public void clickLinkPage(){
        click(focusSerLnkLocator);
        log.info("Clicking Focus Services page");
    }

    public void validateNowHiringBtn(){
        text=find(nowHiringBtnLocator).getText();
        Assert.assertTrue(text.contains("Now Hiring"),
                "Now Hiring button is not appear");
        log.info("'"+text+"'"+" was found in the source page");
    }
}
