package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LocationsPage extends BasePageObject{

    private By locationsLnkLocator = By.xpath("//span[text()='Locations']");
    private By northAmerLnkLocator = By.xpath("//span[text()='North America']");
    private By centralAmerLnkLocator = By.xpath("//span[text()='Central America']");
    private By esNcLocator = By.xpath("//h2[text()='El Salvador & Nicaragua']");
    private By asiaLocator = By.xpath("//span[text()='Asia']");
    private By bacolodLocator = By.xpath("//b[text()='Bacolod City, Philippines']");

    public LocationsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void goToLocationsPage(){
        click(locationsLnkLocator);
        log.info("Clicking on “locations” link");
    }

    public void clickNorthAmerLnk(){
        click(northAmerLnkLocator);
        Assert.assertTrue(find(northAmerLnkLocator).getText().contains("NORTH AMERICA"),
                "North America link is not appear");
        log.info("North America link was found");
    }

    public void clickCentralAmerLnk(){
        click(centralAmerLnkLocator);
        Assert.assertTrue(find(centralAmerLnkLocator).getText().contains("CENTRAL AMERICA"),
                "Central America link is not appear");
        log.info("Central America link was found");
    }

    public void validateEsTitle(){
        String text=find(esNcLocator).getText();
        Assert.assertTrue(text.contains("El Salvador & Nicaragua"),
                "El Salvador & Nicaragua text was not found");
        log.info("El Salvador & Nicaragua text was found");
    }

    public void clickAsiaLnk(){
        click(asiaLocator);
        Assert.assertTrue(find(asiaLocator).getText().contains("ASIA"),
                "Asia link was not found");
        log.info("Asia link was found");
    }

    public void validateBacolodTitle(){
        String text=find(bacolodLocator).getText();
        Assert.assertTrue(text.contains("Bacolod City, Philippines"),
                "Bacolod City, Philippines text was not found");
        log.info("Bacolod City, Philippines text was found");
    }
}
