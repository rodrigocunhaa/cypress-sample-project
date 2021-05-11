package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class ElementsRadioButtonPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By impressiveRadioButton = By.xpath("//input[@id='impressiveRadio']");
    private final By radioButtonResults = By.xpath("//span[@class='text-success']");

    public void selectImpressiveOption(){
        page.clickRadioButton(impressiveRadioButton);
    }

    public String getResultsOutput() {
        return driver.findElement(radioButtonResults).getText();
    }
}
