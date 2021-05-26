package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import util.BasePage;
import util.DriverFactory;

import java.util.List;

public class WidgetsSelectMenuPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);

    private final By selectValueField = By.xpath("//*[@id='withOptGroup']");
    private final By selectOneField = By.xpath("//*[@id='selectOne']");
    private final By oldStyleSelectMenuField = By.xpath("//select[@id='oldSelectMenu']");
    private final By multipleDropDownField = By.xpath("//b[text()='Multiselect drop down']/parent::p/following-sibling::div");
    private final By standardMultiSelectOption = By.xpath("//select[@id='cars']");

    public void selectValueField(String option) {
        page.waitAndClick(selectValueField);
        page.waitAndClick(By.xpath("//*[@tabindex='-1' and text()='" + option + "']"));
    }

    public void selectOneField(String option) {
        page.waitAndClick(selectOneField);
        page.waitAndClick(By.xpath("//*[@tabindex='-1' and text()='" + option + "']"));
    }

    public void oldStyleSelectMenuField(String option) {
        page.selectByValue(oldStyleSelectMenuField,option);
    }

    public void multipleDropDownField(List<String> optionList) {
        page.waitAndClick(multipleDropDownField);

        for (String option : optionList) {
            page.waitAndClick(By.xpath("//*[@tabindex='-1' and text()='" + option + "']"));
        }
    }

    public void standardMultiSelect(List<String> optionList) {
        for (String option : optionList) {
            By standardMultiSelectOption = By.xpath("//select[@id='cars']//option[text()='" + option + "']");
            page.waitAndCommandClick(standardMultiSelectOption);
        }
    }

    public boolean assertSelectValueFieldSelectedOption(String option) {
        By selectValueFieldSelectedOption = By.xpath("//*[@id='withOptGroup']//*[text()='" + option + "']");
        return page.isElementVisible(selectValueFieldSelectedOption);
    }

    public boolean assertSelectOneFieldSelectedOption(String option) {
        By selectOneFieldSelectedOption = By.xpath("//*[@id='selectOne']//*[text()='" + option + "']");
        return page.isElementVisible(selectOneFieldSelectedOption);
    }

    public String getOldStyleSelectMenuFieldSelectedOption() {
        return page.getSelectedOption(oldStyleSelectMenuField);
    }

    public boolean assertMultipleDropDownFieldSelectedOptions(List<String> optionList) {
        for (String option : optionList) {
            By selectOneFieldSelectedOption = By.xpath("//b[text()='Multiselect drop down']/parent::p/following-sibling::div//*[text()='" + option + "']");

            if (!page.isElementVisible(selectOneFieldSelectedOption)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getStandardMultiSelectFieldSelectedOptions () {
        return page.getAllSelectedOptions(standardMultiSelectOption);
    }
}
