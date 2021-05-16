package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.Constants;
import util.DriverFactory;

public class TestForms {
    private WebDriver driver;
    private final FormsPracticeFormPage formsPracticeFormPage = new FormsPracticeFormPage();

    @Before
    public void before(){
        driver = DriverFactory.getDriver();
    }

    @Test
    @DisplayName("Should be able to fill and submit the form")
    public void testFormsPracticeForm(){
        String firstName = "Lainey";
        String lastName = "Ross";
        String email = "nullchar@demoqa.com";
        String mobileNumer = "4865596142";
        String currentAddress = "768 Gainsway Street Lawrenceville, GA 30043";

        driver.get(Constants.TOOLS_QA_FORMS_PRACTICE_FORM_URL);
        formsPracticeFormPage.submitForm(firstName, lastName, email, mobileNumer, currentAddress);

        Assert.assertTrue(formsPracticeFormPage.getStudentNameValue().contains("Lainey Ross"));
        Assert.assertTrue(formsPracticeFormPage.getStudentEmailValue().contains(email));
        Assert.assertTrue(formsPracticeFormPage.getGenderValue().contains("Male"));
        Assert.assertTrue(formsPracticeFormPage.getMobileValue().contains(mobileNumer));
        Assert.assertTrue(formsPracticeFormPage.getDateOfBirthValue().contains("7 July,2020"));
        Assert.assertTrue(formsPracticeFormPage.getSubjectsValue().contains("Maths"));
        Assert.assertTrue(formsPracticeFormPage.getHobbiesValue().contains("Sports, Music"));
        Assert.assertTrue(formsPracticeFormPage.getPictureValue().contains("testPicture.png"));
        Assert.assertTrue(formsPracticeFormPage.getAddressValue().contains("768 Gainsway Street Lawrenceville, GA 30043"));
        Assert.assertTrue(formsPracticeFormPage.getStateAndCityValue().contains("NCR Delhi"));

    }

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
