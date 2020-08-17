package base;

import org.openqa.selenium.JavascriptExecutor;

public class TestUtilities extends BaseTest{

    //static sleep
    protected void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //This method scroll down on the page
    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

}
