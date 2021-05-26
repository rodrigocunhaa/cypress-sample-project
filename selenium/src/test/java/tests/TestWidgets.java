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

import java.util.Arrays;
import java.util.List;

public class TestWidgets {
    private WebDriver driver;
    private final WidgetsAccordianPage widgetsAccordianPage = new WidgetsAccordianPage();
    private final WidgetsAutoCompletePage widgetsAutoCompletePage = new WidgetsAutoCompletePage();
    private final WidgetsDatePickerPage widgetsDatePickerPage = new WidgetsDatePickerPage();
    private final WidgetsSliderPage widgetsSliderPage = new WidgetsSliderPage();
    private final WidgetsProgressBarPage widgetsProgressBarPage = new WidgetsProgressBarPage();
    private final WidgetsTabsPage widgetsTabsPage = new WidgetsTabsPage();
    private final WidgetsMenu widgetsMenu = new WidgetsMenu();
    private final WidgetsToolTipsPage widgetsToolTipsPage = new WidgetsToolTipsPage();
    private final WidgetsSelectMenuPage widgetsSelectMenuPage = new WidgetsSelectMenuPage();

    private BasePage page;

    @Before
    public void before() {
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

    @Test
    @DisplayName("Should be able to interact with Progress Bar Widgets")
    public void testProgressBar() throws InterruptedException {
        driver.get(Constants.TOOLS_QA_WIDGETS_PROGRESS_BAR_URL);

        widgetsProgressBarPage.clickStartStopButton();

        Thread.sleep(5000);
        widgetsProgressBarPage.clickStartStopButton();

        Assert.assertEquals("50", widgetsProgressBarPage.getProgressBarAttributes().get(0));
        Assert.assertEquals("50%", widgetsProgressBarPage.getProgressBarAttributes().get(1));
        Assert.assertEquals("width: 50%;", widgetsProgressBarPage.getProgressBarAttributes().get(2));

        widgetsProgressBarPage.clickStartStopButton();

        Thread.sleep(5000);

        Assert.assertEquals("100", widgetsProgressBarPage.getProgressBarAttributes().get(0));
        Assert.assertEquals( "100%", widgetsProgressBarPage.getProgressBarAttributes().get(1));
        Assert.assertEquals( "width: 100%;", widgetsProgressBarPage.getProgressBarAttributes().get(2));

        Assert.assertEquals("100%", widgetsProgressBarPage.getSuccessTextValue());

        widgetsProgressBarPage.clickResetButton();
    }

    @Test
    @DisplayName("Should be able to interact with Tabs Widgets")
    public void testTabs() {
        driver.get(Constants.TOOLS_QA_WIDGETS_TABS_URL);

        Assert.assertEquals("What", widgetsTabsPage.getDemoTabWhatAttributes().get(0));
        Assert.assertEquals("true", widgetsTabsPage.getDemoTabWhatAttributes().get(1));
        Assert.assertEquals("nav-item nav-link active", widgetsTabsPage.getDemoTabWhatAttributes().get(2));

        Assert.assertEquals("Origin", widgetsTabsPage.getDemoTabOriginAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabOriginAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabOriginAttributes().get(2));

        Assert.assertEquals("Use", widgetsTabsPage.getDemoTabUseAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabUseAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabUseAttributes().get(2));

        Assert.assertEquals("More", widgetsTabsPage.getDemoTabMoreAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabMoreAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabMoreAttributes().get(2));

        Assert.assertTrue(widgetsTabsPage.getDemoTabPanelWhatText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

        Assert.assertEquals("false", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(0));
        Assert.assertEquals("fade tab-pane active show", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneUseAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneUseAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(1));

        widgetsTabsPage.clickDemoTabOrigin();

        Assert.assertEquals("What", widgetsTabsPage.getDemoTabWhatAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabWhatAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabWhatAttributes().get(2));

        Assert.assertEquals("Origin", widgetsTabsPage.getDemoTabOriginAttributes().get(0));
        Assert.assertEquals("true", widgetsTabsPage.getDemoTabOriginAttributes().get(1));
        Assert.assertEquals("nav-item nav-link active", widgetsTabsPage.getDemoTabOriginAttributes().get(2));

        Assert.assertEquals("Use", widgetsTabsPage.getDemoTabUseAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabUseAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabUseAttributes().get(2));

        Assert.assertEquals("More", widgetsTabsPage.getDemoTabMoreAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabMoreAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabMoreAttributes().get(2));

        Assert.assertTrue(widgetsTabsPage.getDemoTabPanelOriginText().contains("Contrary to popular belief, Lorem Ipsum is not simply random text."));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(1));

        Assert.assertEquals("false", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(0));
        Assert.assertEquals("fade tab-pane active show", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneUseAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneUseAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(1));

        widgetsTabsPage.clickDemoTabUse();

        Assert.assertEquals("What", widgetsTabsPage.getDemoTabWhatAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabWhatAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabWhatAttributes().get(2));

        Assert.assertEquals("Origin", widgetsTabsPage.getDemoTabOriginAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabOriginAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabOriginAttributes().get(2));

        Assert.assertEquals("Use", widgetsTabsPage.getDemoTabUseAttributes().get(0));
        Assert.assertEquals("true", widgetsTabsPage.getDemoTabUseAttributes().get(1));
        Assert.assertEquals("nav-item nav-link active", widgetsTabsPage.getDemoTabUseAttributes().get(2));

        Assert.assertEquals("More", widgetsTabsPage.getDemoTabMoreAttributes().get(0));
        Assert.assertEquals("false", widgetsTabsPage.getDemoTabMoreAttributes().get(1));
        Assert.assertNotEquals("nav-link active", widgetsTabsPage.getDemoTabMoreAttributes().get(2));

        Assert.assertTrue(widgetsTabsPage.getDemoTabPanelUseText().contains("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneWhatAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneOriginAttributes().get(1));

        Assert.assertEquals("false", widgetsTabsPage.getDemoTabPaneUseAttributes().get(0));
        Assert.assertEquals("fade tab-pane active show", widgetsTabsPage.getDemoTabPaneUseAttributes().get(1));

        Assert.assertEquals("true", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(0));
        Assert.assertNotEquals("active show", widgetsTabsPage.getDemoTabPaneMoreAttributes().get(1));

    }

    @Test
    @DisplayName("Should be able to interact with Tool Tips Widgets")
    public void testToolTips() throws InterruptedException {
        driver.get(Constants.TOOLS_QA_WIDGETS_TOOL_TIPS_URL);

        String actualResult = "You hovered over the Button";
        String expectedResult =  widgetsToolTipsPage.getHoverMeToSeeButtonToolTipText();
        Assert.assertEquals(actualResult,expectedResult);

        actualResult = "You hovered over the text field";
        expectedResult =  widgetsToolTipsPage.getTextFieldToolTipText();
        Assert.assertEquals(actualResult,expectedResult);

        actualResult = "You hovered over the Contrary";
        expectedResult =  widgetsToolTipsPage.getContraryTextToolTipText();
        Assert.assertEquals(actualResult,expectedResult);

        actualResult = "You hovered over the 1.10.32";
        expectedResult =  widgetsToolTipsPage.getNumberTextToolTipText();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    @DisplayName("Should be able to interact with Menu Widgets")
    public void testMenu() throws InterruptedException {
        driver.get(Constants.TOOLS_QA_WIDGETS_MENU_URL);

        Assert.assertTrue(widgetsMenu.isMenuItem1Visible());
        Assert.assertTrue(widgetsMenu.isMenuItem2Visible());
        Assert.assertTrue(widgetsMenu.isMenuItem3Visible());

        widgetsMenu.mouseOverMenuItem2();

        Assert.assertTrue(widgetsMenu.isSubItemVisible());
        Assert.assertTrue(widgetsMenu.isSubSubListVisible());

        widgetsMenu.mouseOverSubSubList();

        Assert.assertTrue(widgetsMenu.isMenuSubItem1Visible());
        Assert.assertTrue(widgetsMenu.isMenuSubItem2Visible());
    }

    @Test
    @DisplayName("Should be able to interact with Select Menu Widgets")
    public void testSelectMenu() {
        driver.get(Constants.TOOLS_QA_WIDGETS_SELECT_MENU_URL);

        widgetsSelectMenuPage.selectValueField("A root option");

        Assert.assertTrue(widgetsSelectMenuPage.assertSelectValueFieldSelectedOption("A root option"));

        widgetsSelectMenuPage.selectOneField("Mrs.");

        Assert.assertTrue(widgetsSelectMenuPage.assertSelectOneFieldSelectedOption("Mrs."));

        widgetsSelectMenuPage.oldStyleSelectMenuField("Black");

        String expectedResult = "Black";
        String actualResult = widgetsSelectMenuPage.getOldStyleSelectMenuFieldSelectedOption();
        Assert.assertEquals(expectedResult,actualResult);

        List<String> multipleDropDownOptionList = Arrays.asList("Red", "Green");
        widgetsSelectMenuPage.multipleDropDownField(multipleDropDownOptionList);

        Assert.assertTrue(widgetsSelectMenuPage.assertMultipleDropDownFieldSelectedOptions(multipleDropDownOptionList));

        List<String> standardMultiSelectOptionList = Arrays.asList("Volvo","Opel");
        widgetsSelectMenuPage.standardMultiSelect(standardMultiSelectOptionList);

        List<String> actualResultList = widgetsSelectMenuPage.getStandardMultiSelectFieldSelectedOptions();
        Assert.assertArrayEquals(standardMultiSelectOptionList.toArray(),actualResultList.toArray());
    }

    @After
    public void after() {
        DriverFactory.quitDriver();
    }
}
