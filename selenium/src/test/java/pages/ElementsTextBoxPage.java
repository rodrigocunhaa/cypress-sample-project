package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class ElementsTextBoxPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By fullNameTextField = By.xpath("//input[@id='userName']");
    private final By emailTextField = By.xpath("//input[@id='userEmail']");
    private final By currentAddressTextField = By.xpath("//textarea[@id='currentAddress']");
    private final By permanentAddressTextField = By.xpath("//textarea[@id='permanentAddress']");
    private final By submitFormButton = By.xpath("//button[@id='submit']");
    private final By fullNameOutput = By.xpath("//p[@id='name']");
    private final By emailOutput = By.xpath("//p[@id='email']");
    private final By currentAddressOutput = By.xpath("//p[@id='currentAddress']");
    private final By permanentAddressOutput = By.xpath("//p[@id='permanentAddress']");

    public void submitForm (String fullName, String email, String currentAddress, String permanentAddress) {
        page.waitAndSendKeys(fullNameTextField, fullName);
        page.waitAndSendKeys(emailTextField, email);
        page.waitAndSendKeys(currentAddressTextField, currentAddress);
        page.waitAndSendKeys(permanentAddressTextField, permanentAddress);
        page.waitAndClick(submitFormButton);
    }

    public String getFullNameOutput() {
        return driver.findElement(fullNameOutput).getText();
    }

    public String getEmailOutput() {
        return driver.findElement(emailOutput).getText();
    }

    public String getCurrentAddressOutput() {
        return driver.findElement(currentAddressOutput).getText();
    }

    public String getPermanentAddressOutput() {
        return driver.findElement(permanentAddressOutput).getText();
    }

}
