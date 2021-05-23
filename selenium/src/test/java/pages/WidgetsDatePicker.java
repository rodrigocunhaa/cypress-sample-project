package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class WidgetsDatePicker {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By datePicker = By.xpath("//input[@id='datePickerMonthYearInput']");
    private final By monthSelector = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By yearSelector = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By daySevenOfJuly = By.xpath("//div[@class='react-datepicker__week']//div[contains(@aria-label,'July 7th')]");
    private final By dateAndTimePicker = By.xpath("//input[@id='dateAndTimePickerInput']");
    private final By monthDropdown = By.xpath("//div[contains(@class,'react-datepicker__month-dropdown-container')]");
    private final By monthDropdownJuly = By.xpath("//div[@class='react-datepicker__month-option' and text()='July']");
    private final By yearDropdown = By.xpath("//div[contains(@class,'react-datepicker__year-dropdown-container')]");
    private final By yearDropdown1993 = By.xpath("//div[@class='react-datepicker__year-option' and text()='1993']");
    private final By yearDropDownPrevious = By.xpath("//a[contains(@class,'react-datepicker__navigation--years-previous')]");
    private final By timeSelectorTenPM = By.xpath("//div[@class='react-datepicker__time-box']//li[contains(text(),'22:00')]");

    public void fillDateAndTimePicker() {
        page.waitAndClick(dateAndTimePicker);
        page.waitAndClick(monthDropdown);
        page.waitAndClick(monthDropdownJuly);
        page.waitAndClick(daySevenOfJuly);
        page.waitAndClick(yearDropdown);

        for (int i=0; i<30; i++){
            page.waitAndClick(yearDropDownPrevious);
        }

        page.waitAndClick(yearDropdown1993);
        page.waitAndClick(timeSelectorTenPM);
    }

    public void fillDatePicker() {
        page.waitAndClick(datePicker);
        page.selectByValue(monthSelector, "July");
        page.selectByValue(yearSelector, "1993");
        page.waitAndClick(daySevenOfJuly);
    }

    public String getValueFromDatePicker() {
        return driver.findElement(datePicker).getAttribute("value");
    }

    public String getValueFromDateAndTimePicker() {
        return driver.findElement(dateAndTimePicker).getAttribute("value");
    }
}
