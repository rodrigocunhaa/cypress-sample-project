package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

import java.util.List;

public class ElementsWebTablesPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By searchBoxField = By.xpath("//input[@id='searchBox']");
    private final By tableCell = By.xpath("//div[@role='gridcell']");
    private final By addNewRecordButton = By.xpath("//button[@id='addNewRecordButton']");
    private final By firstNameField = By.xpath("//input[@id='firstName']");
    private final By lastNameField = By.xpath("//input[@id='lastName']");
    private final By emailField = By.xpath("//input[@id='userEmail']");
    private final By ageField = By.xpath("//input[@id='age']");
    private final By salaryField = By.xpath("//input[@id='salary']");
    private final By departmentField = By.xpath("//input[@id='department']");
    private final By submitButton = By.xpath("//button[@id='submit']");


    public void searchByText (String value) {
        page.waitAndClear(searchBoxField);
        page.waitAndSendKeys(searchBoxField, value);
    }

    public List<String> getAllTableCellText() {
        return page.getAllTextFromElements(tableCell);
    }

    public void addNewRecord (String firstName, String lastName, String email, String age, String salary, String department) {
        page.waitAndClick(addNewRecordButton);
        page.waitAndSendKeys(firstNameField, firstName);
        page.waitAndSendKeys(lastNameField, lastName);
        page.waitAndSendKeys(emailField, email);
        page.waitAndSendKeys(ageField, age);
        page.waitAndSendKeys(salaryField, salary);
        page.waitAndSendKeys(departmentField, department);
        page.waitAndClick(submitButton);
    }
}
