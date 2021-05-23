package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class WidgetsAutoCompletePage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By multipleColorsAutoComplete = By.xpath("//*[@id='autoCompleteMultipleContainer']//input");
    private final By singleColorAutoComplete = By.xpath("//*[@id='autoCompleteSingleContainer']//input");

    public void clickAutoCompleteOption(String option) {
        By multipleColorsOption = By.xpath("//*[contains(@class,'auto-complete__option')][contains(text(),'"+option+"')]");
        page.waitAndClick(multipleColorsOption);
    }

    public void fillMultipleColorsAutoCompleteField (String value) {
        page.waitAndSendKeys(multipleColorsAutoComplete, value);
    }

    public void fillSingleColorsAutoCompleteField (String value) {
        page.waitAndSendKeys(singleColorAutoComplete, value);
    }

    public boolean visibilityOfMultipleAutoCompleteLabel (String value){
        By multipleColorsLabel = By.xpath("//*[contains(@class,'auto-complete__multi-value__label')][contains(text(),'"+value+"')]");
        return page.isElementVisible(multipleColorsLabel);
    }

    public boolean visibilityOfSingleAutoCompleteLabel (String value){
        By multipleColorsLabel = By.xpath("//*[contains(@class,'auto-complete__single-value')][contains(text(),'"+value+"')]");
        try {
            return page.isElementVisible(multipleColorsLabel);
        } catch (TimeoutException e) {
            return false;
        }
    }
}
