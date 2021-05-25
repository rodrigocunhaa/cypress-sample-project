package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

import java.util.ArrayList;

public class WidgetsProgressBarPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By startStopButton = By.xpath("//button[@id='startStopButton']");
    private final By resetButton = By.xpath("//button[@id='resetButton']");
    private final By valueNow = By.xpath("//div[@aria-valuenow]");
    private final By successText = By.xpath("//div[contains(@class,'bg-success')]");

    public void clickStartStopButton() {
        page.waitAndClick(startStopButton);
    }

    public void clickResetButton() {
        page.waitAndClick(resetButton);
    }

    public ArrayList<String> getProgressBarAttributes() {
        String ariaValueNowAttr = driver.findElement(valueNow).getAttribute("aria-valuenow");
        String textAttr = driver.findElement(valueNow).getText();
        String styleAttr = driver.findElement(valueNow).getAttribute("style");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(ariaValueNowAttr);
        listOfAttributes.add(textAttr);
        listOfAttributes.add(styleAttr);

        return listOfAttributes;
    }

    public String getSuccessTextValue() {
        return driver.findElement(successText).getText();
    }

}
