package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationsPage extends BasePageObject{

    private By locationsLnkLocator = By.xpath("//span[text()='Locations']");

    public LocationsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void goToLocationsPage(){
        click(locationsLnkLocator);
        log.info("Clicking on “locations” link");
    }
}
