package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class FormsPracticeFormPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By firstNameTextField = By.xpath("//input[@id='firstName']");
    private final By lastNameTextField = By.xpath("//input[@id='lastName']");
    private final By genderMaleRadioButton = By.xpath("//input[@id='gender-radio-1']");
    private final By emailTextField = By.xpath("//input[@id='userEmail']");
    private final By mobileNumberTextField = By.xpath("//input[@id='userNumber']");
    private final By dateOfBirthInput = By.xpath("//input[@id='dateOfBirthInput']");
    private final By selectMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By selectYear = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By daySevenOfJuly = By.xpath("//div[@class='react-datepicker__week']//div[contains(@aria-label,'July 7th')]");
    private final By subjectsInput = By.xpath("//input[@id='subjectsInput']");
    private final By mathInput = By.xpath("//div[contains(@class,'subjects-auto-complete__option') and text()='Maths']");
    private final By hobbySportsCheckBox = By.xpath("//label[contains(text(),'Sports')]");
    private final By hobbyMusicCheckBox = By.xpath("//label[contains(text(),'Music')]");
    private final By pictureField = By.xpath("//input[@type='file']");
    private final By currentAddressTextField = By.xpath("//textarea[@id='currentAddress']");
    private final By stateField = By.xpath("//div[@id='state']");
    private final By StateCityText = By.xpath("//*[contains(@tabindex,'-1')]");
    private final By cityField = By.xpath("//div[@id='city']");
    private final By submitFormButton = By.xpath("//button[@id='submit']");
    private final By studentNameValue = By.xpath("//td[contains(text(),'Student Name')]/following-sibling::td");
    private final By studentEmailValue = By.xpath("//td[contains(text(),'Student Email')]/following-sibling::td");
    private final By genderValue = By.xpath("//td[contains(text(),'Gender')]/following-sibling::td");
    private final By mobileValue = By.xpath("//td[contains(text(),'Mobile')]/following-sibling::td");
    private final By dateOfBirthValue = By.xpath("//td[contains(text(),'Date of Birth')]/following-sibling::td");
    private final By subjectsValue = By.xpath("//td[contains(text(),'Subjects')]/following-sibling::td");
    private final By hobbiesValue = By.xpath("//td[contains(text(),'Hobbies')]/following-sibling::td");
    private final By pictureValue = By.xpath("//td[contains(text(),'Picture')]/following-sibling::td");
    private final By addressValue = By.xpath("//td[contains(text(),'Address')]/following-sibling::td");
    private final By stateAndCityValue = By.xpath("//td[contains(text(),'State and City')]/following-sibling::td");

    public String getStudentNameValue() {
        return driver.findElement(studentNameValue).getText();
    }

    public String getStudentEmailValue() {
        return driver.findElement(studentEmailValue).getText();
    }

    public String getGenderValue() {
        return driver.findElement(genderValue).getText();
    }

    public String getMobileValue() {
        return driver.findElement(mobileValue).getText();
    }

    public String getDateOfBirthValue() {
        return driver.findElement(dateOfBirthValue).getText();
    }

    public String getSubjectsValue() {
        return driver.findElement(subjectsValue).getText();
    }

    public String getHobbiesValue() {
        return driver.findElement(hobbiesValue).getText();
    }

    public String getPictureValue() {
        return driver.findElement(pictureValue).getText();
    }

    public String getAddressValue() {
        return driver.findElement(addressValue).getText();
    }

    public String getStateAndCityValue() {
        return driver.findElement(stateAndCityValue).getText();
    }

    public void submitForm (String firstName, String lastName, String email, String mobileNumber, String currentAddress) {
        page.waitAndSendKeys(firstNameTextField, firstName);
        page.waitAndSendKeys(lastNameTextField, lastName);
        page.waitAndSendKeys(emailTextField, email);
        page.clickRadioButton(genderMaleRadioButton);
        page.waitAndClick(dateOfBirthInput);
        page.selectByValue(selectMonth, "July");
        page.selectByValue(selectYear, "2020");
        page.waitAndClick(daySevenOfJuly);
        page.waitAndSendKeys(subjectsInput, "Maths");
        page.waitAndClick(mathInput);
        page.waitAndClick(hobbySportsCheckBox);
        page.waitAndClick(hobbyMusicCheckBox);
        page.uploadImage(pictureField, "testPicture.png");
        page.waitAndSendKeys(currentAddressTextField, currentAddress);
        page.waitAndSendKeys(mobileNumberTextField, mobileNumber);
        page.scrollUntilTheEnd();
        page.waitAndClick(stateField);
        page.waitAndClick(StateCityText);
        page.waitAndClick(cityField);
        page.waitAndClick(StateCityText);
        page.waitAndClick(submitFormButton);
    }

}
