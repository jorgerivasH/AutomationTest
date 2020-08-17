package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain some useful methods to navigate on any web page
 * */
public class BasePageObject {
    protected WebDriver driver;
    protected  Logger log;

    //Constructor
    public BasePageObject(WebDriver driver, Logger log){
        this.driver=driver;
        this.log=log;
    }

    //This method open page with given URL
    public void openUrl(String url){
        driver.get(url);
        log.info("the url: "+url+" was opening");
    }

    //Find element using given locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    //Click on element with given locator when is visible
    public void click(By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    //Type given test into element with given locator
    public void type(String text , By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    //Wait for a given number of seconds for element with given locator to be visible on the page
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while(attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0]: null));
                break;
            }catch (StaleElementReferenceException e){
                e.getMessage();
            }
            attempts++;
        }
    }

    //Wait for specific Expected condition for the given amount of time in seconds
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }
}
