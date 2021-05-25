package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.BasePage;
import util.Constants;
import util.DriverFactory;

public class TestWidgets {
    private WebDriver driver;
    private final WidgetsAccordianPage widgetsAccordianPage = new WidgetsAccordianPage();
    private final WidgetsAutoCompletePage widgetsAutoCompletePage = new WidgetsAutoCompletePage();
    private final WidgetsDatePickerPage widgetsDatePickerPage = new WidgetsDatePickerPage();
    private final WidgetsSliderPage widgetsSliderPage = new WidgetsSliderPage();

    private BasePage page;

    @Before
    public void before(){
        driver = DriverFactory.getDriver();
        page = new BasePage(driver);
    }

    @Test
    @DisplayName("Should be able to interact with Accordian Widgets")
    public void testWidgetsAccordian() {

        driver.get(Constants.TOOLS_QA_WIDGETS_ACCORDIAN_URL);

        Assert.assertTrue(widgetsAccordianPage.getWhatIsLoremIpsumTitleText().contains("What is Lorem Ipsum?"));
        Assert.assertTrue(widgetsAccordianPage.isWhatIsLoremIpsumShownFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhereDoesItComeFromTitleText().contains("Where does it come from?"));
        Assert.assertTrue(widgetsAccordianPage.isWhereDoesItComeFromCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhyDoWeUseItTitleText().contains("Why do we use it?"));
        Assert.assertTrue(widgetsAccordianPage.isWhyDoWeUseItCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhatIsLoremIpsumText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

        widgetsAccordianPage.clickWhereDoesItComeFromTitle();
        Assert.assertTrue(widgetsAccordianPage.getWhatIsLoremIpsumTitleText().contains("What is Lorem Ipsum?"));
        Assert.assertTrue(widgetsAccordianPage.isWhatIsLoremIpsumCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhereDoesItComeFromTitleText().contains("Where does it come from?"));
        Assert.assertTrue(widgetsAccordianPage.isWhereDoesItComeFromShownFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhyDoWeUseItTitleText().contains("Why do we use it?"));
        Assert.assertTrue(widgetsAccordianPage.isWhyDoWeUseItCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhereDoesItComeFromText().contains("Contrary to popular belief, Lorem Ipsum is not simply random text."));

        page.scrollUntilTheEnd();

        widgetsAccordianPage.clickWhyDoWeUseItTitle();
        Assert.assertTrue(widgetsAccordianPage.getWhatIsLoremIpsumTitleText().contains("What is Lorem Ipsum?"));
        Assert.assertTrue(widgetsAccordianPage.isWhatIsLoremIpsumCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhereDoesItComeFromTitleText().contains("Where does it come from?"));
        Assert.assertTrue(widgetsAccordianPage.isWhereDoesItComeFromCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhyDoWeUseItTitleText().contains("Why do we use it?"));
        Assert.assertTrue(widgetsAccordianPage.isWhyDoWeUseItShownFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhyDoWeUseItText().contains("It is a long established fact that a reader will be distracted by the readable content"));

        widgetsAccordianPage.clickWhyDoWeUseItTitle();
        Assert.assertTrue(widgetsAccordianPage.getWhatIsLoremIpsumTitleText().contains("What is Lorem Ipsum?"));
        Assert.assertTrue(widgetsAccordianPage.isWhatIsLoremIpsumCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhereDoesItComeFromTitleText().contains("Where does it come from?"));
        Assert.assertTrue(widgetsAccordianPage.isWhereDoesItComeFromCollapsedFlag());
        Assert.assertTrue(widgetsAccordianPage.getWhyDoWeUseItTitleText().contains("Why do we use it?"));
        Assert.assertTrue(widgetsAccordianPage.isWhyDoWeUseItCollapsedFlag());
    }

    @Test
    @DisplayName("Should be able to interact with Auto Complete Widgets")
    public void testWidgetsAutoComplete() {
        driver.get(Constants.TOOLS_QA_WIDGETS_AUTO_COMPLETE_URL);

        widgetsAutoCompletePage.fillMultipleColorsAutoCompleteField("r");
        widgetsAutoCompletePage.clickAutoCompleteOption("Green");
        widgetsAutoCompletePage.fillMultipleColorsAutoCompleteField("r");
        widgetsAutoCompletePage.clickAutoCompleteOption("Red");

        Assert.assertTrue(widgetsAutoCompletePage.visibilityOfMultipleAutoCompleteLabel("Green"));
        Assert.assertTrue(widgetsAutoCompletePage.visibilityOfMultipleAutoCompleteLabel("Red"));

        widgetsAutoCompletePage.fillSingleColorsAutoCompleteField("r");
        widgetsAutoCompletePage.clickAutoCompleteOption("Purple");

        Assert.assertTrue(widgetsAutoCompletePage.visibilityOfSingleAutoCompleteLabel("Purple"));

        widgetsAutoCompletePage.fillSingleColorsAutoCompleteField("r");
        widgetsAutoCompletePage.clickAutoCompleteOption("Green");

        Assert.assertTrue(widgetsAutoCompletePage.visibilityOfSingleAutoCompleteLabel("Green"));
        Assert.assertFalse(widgetsAutoCompletePage.visibilityOfSingleAutoCompleteLabel("Purple"));

    }

    @Test
    @DisplayName("Should be able to interact with Date Picker Widgets")
    public void testWidgetsDatePicker() {
        driver.get(Constants.TOOLS_QA_WIDGETS_DATE_PICKER_URL);

        widgetsDatePickerPage.fillDatePicker();
        Assert.assertTrue(widgetsDatePickerPage.getValueFromDatePicker().contains("07/07/1993"));

        widgetsDatePickerPage.fillDateAndTimePicker();
        Assert.assertTrue(widgetsDatePickerPage.getValueFromDateAndTimePicker().contains("July 7, 2021 10:00 PM"));

    }

    @Test
    @DisplayName("Should be able to interact with Slider Widgets")
    public void testWidgetsSlider() {
        driver.get(Constants.TOOLS_QA_WIDGETS_SLIDER_URL);

        widgetsSliderPage.move();
        Assert.assertEquals(widgetsSliderPage.getValueFromSlider(), "25");

    }

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
