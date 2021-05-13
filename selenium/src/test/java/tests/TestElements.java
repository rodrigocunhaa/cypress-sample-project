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

import java.util.List;

public class TestElements {
    private WebDriver driver;
    private final ElementsTextBoxPage elementsTextBoxPage = new ElementsTextBoxPage();
    private final ElementsCheckBoxPage elementsCheckBoxPage = new ElementsCheckBoxPage();
    private final ElementsRadioButtonPage elementsRadioButtonPage = new ElementsRadioButtonPage();
    private final ElementsWebTablesPage elementsWebTablesPage = new ElementsWebTablesPage();
    private final ElementsButtonsPage elementsButtonsPage = new ElementsButtonsPage();

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
    public void testElementsRadioButton(){
        driver.get(Constants.TOOLS_QA_ELEMENTS_RADIO_BUTTON_URL);
        elementsRadioButtonPage.selectImpressiveOption();
        Assert.assertTrue(elementsRadioButtonPage.getResultsOutput().contains("Impressive"));
    }

    @Test
    @DisplayName("Should be able to read from Table")
    public void testElementsWebTables(){
        driver.get(Constants.TOOLS_QA_ELEMENTS_WEB_TABLES_URL);

        elementsWebTablesPage.searchByText("2000");
        List<String> allTextFromTable = elementsWebTablesPage.getAllTableCellText();

        Assert.assertTrue(allTextFromTable.contains("Alden"));
        Assert.assertTrue(allTextFromTable.contains("12000"));
        Assert.assertTrue(allTextFromTable.contains("Kierra"));
        Assert.assertTrue(allTextFromTable.contains("2000"));

        elementsWebTablesPage.addNewRecord("Diamond", "Farley", "dfarley@demoqa.com", "45", "2000", "IT");

        allTextFromTable = elementsWebTablesPage.getAllTableCellText();
        Assert.assertTrue(allTextFromTable.contains("Farley"));

        elementsWebTablesPage.searchByText("45");

        allTextFromTable = elementsWebTablesPage.getAllTableCellText();
        Assert.assertFalse(allTextFromTable.contains("Kierra"));

    }

    @Test
    @DisplayName("Should be able to interact with Buttons (click, double-click and right-click)")
    public void testElementsButtons(){
        driver.get(Constants.TOOLS_QA_ELEMENTS_BUTTONS_URL);

        elementsButtonsPage.clickOnDoubleClickButton();
        Assert.assertTrue(elementsButtonsPage.getDoubleClickMessage().contains("You have done a double click"));

        elementsButtonsPage.clickOnRightClickButton();
        Assert.assertTrue(elementsButtonsPage.getRightClickMessage().contains("You have done a right click"));

        elementsButtonsPage.clickOnClickMeButton();
        Assert.assertTrue(elementsButtonsPage.getClickMeMessage().contains("You have done a dynamic click"));

    }

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
