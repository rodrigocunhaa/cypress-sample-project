package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.ElementsCheckBoxPage;
import pages.ElementsRadioButtonPage;
import pages.ElementsTextBoxPage;
import util.Constants;
import util.DriverFactory;

public class TestElements {
    private WebDriver driver;
    private final ElementsTextBoxPage elementsTextBoxPage = new ElementsTextBoxPage();
    private final ElementsCheckBoxPage elementsCheckBoxPage = new ElementsCheckBoxPage();
    private final ElementsRadioButtonPage elementsRadioButtonPage = new ElementsRadioButtonPage();

    @Before
    public void before(){
        driver = DriverFactory.getDriver();
    }

    @Test
    @DisplayName("Should be able to fill Text Box and submit the form")
    public void testElementsTextBox(){
        String fullName = "Diamond Farley";
        String email = "dfarley@demoqa.com";
        String currentAddress = "986 Golden Star Ave.Oxford, MS 3865";
        String permanentAddress = "90 E. St Margarets St.Springfield, PA 19064";

        driver.get(Constants.TOOLS_QA_ELEMENTS_TEXT_BOX_URL);
        elementsTextBoxPage.submitForm(fullName, email, currentAddress, permanentAddress);

        Assert.assertTrue(elementsTextBoxPage.getFullNameOutput().contains(fullName));
        Assert.assertTrue(elementsTextBoxPage.getEmailOutput().contains(email));
        Assert.assertTrue(elementsTextBoxPage.getCurrentAddressOutput().contains(currentAddress));
        Assert.assertTrue(elementsTextBoxPage.getPermanentAddressOutput().contains(permanentAddress));
    }

    @Test
    @DisplayName("Should be able to fill Checkbox")
    public void testElementsCheckBox(){
        driver.get(Constants.TOOLS_QA_ELEMENTS_CHECK_BOX_URL);
        elementsCheckBoxPage.selectPrivateCheckBoxOption();
        Assert.assertTrue(elementsCheckBoxPage.getResultsOutput().contains("private"));
    }

    @Test
    @DisplayName("Should be able to fill Radio Button")
    public void testElementsRadiobutton(){
        driver.get(Constants.TOOLS_QA_ELEMENTS_RADIO_BUTTON_URL);
        elementsRadioButtonPage.selectImpressiveOption();
        Assert.assertTrue(elementsRadioButtonPage.getResultsOutput().contains("Impressive"));
    }

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
