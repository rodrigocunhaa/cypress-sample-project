package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class ElementsCheckBoxPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By expandAllOption = By.xpath("//button[contains(@class,'option-expand-all')]");
    private final By privateOption = By.xpath("//label[@for='tree-node-private']");
    private final By results = By.xpath("//div[@id='result']");

    public void selectPrivateCheckBoxOption(){
        page.waitAndClick(expandAllOption);
        page.waitAndClick(privateOption);
    }

    public String getResultsOutput() {
        return driver.findElement(results).getText();
    }
}
