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

public class TestAlertsFormsWindows {
    private WebDriver driver;
    private BasePage page;
    private final AlertsFormsWindowsModalDialogsPage alertsFormsWindowsModalDialogsPage = new AlertsFormsWindowsModalDialogsPage();
    private final AlertsFormsWindowsBrowserWindowsPage alertsFormsWindowsBrowserWindowsPage = new AlertsFormsWindowsBrowserWindowsPage();
    private final AlertsFormsWindowsAlertsPage alertsFormsWindowsAlertsPage = new AlertsFormsWindowsAlertsPage();

    @Before
    public void before(){
        driver = DriverFactory.getDriver();
        page = new BasePage(driver);
    }

    @Test
    @DisplayName("Should be able to interact with modals - Small and Large modals")
    public void testAlertsFormsWindowsModals() {

        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_MODAL_DIALOGS_URL);

        alertsFormsWindowsModalDialogsPage.openSmallDialog();
        Assert.assertTrue(alertsFormsWindowsModalDialogsPage.getModalText().contains("This is a small modal. It has very less content"));
        alertsFormsWindowsModalDialogsPage.closeSmallDialog();

        alertsFormsWindowsModalDialogsPage.openLargeDialog();
        Assert.assertTrue(alertsFormsWindowsModalDialogsPage.getModalText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        alertsFormsWindowsModalDialogsPage.closeLargeDialog();
    }

    @Test
    @DisplayName("Should be able to interact with browser windows")
    public void testAlertsFormsWindowsBrowserWindows() {

        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_BROWSER_WINDOWS_URL);

        alertsFormsWindowsBrowserWindowsPage.clickTabButton();
        page.switchToTab();
        Assert.assertTrue(alertsFormsWindowsBrowserWindowsPage.getTabWindowText().contains("This is a sample page"));
        page.closeTabAndReturn();

        alertsFormsWindowsBrowserWindowsPage.clickWindowButton();
        page.switchToWindow();
        Assert.assertTrue(alertsFormsWindowsBrowserWindowsPage.getTabWindowText().contains("This is a sample page"));
        page.closeWindowAndReturn();

        alertsFormsWindowsBrowserWindowsPage.clickMessageWindowButton();
        page.switchToWindow();
        page.closeWindowAndReturn();
    }

    @Test
    @DisplayName("Should be able to interact with alerts 1  - Click Button to see alert")
    public void testAlertsFormsWindowsAlerts1() {
        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_ALERTS_URL);

        alertsFormsWindowsAlertsPage.clickAlertButton();

        Assert.assertEquals(alertsFormsWindowsAlertsPage.getTextFromAlert(), "You clicked a button");
    }

    @Test
    @DisplayName("Should be able to interact with alerts 2 - Alert appears after 5 seconds")
    public void testAlertsFormsWindowsAlerts2() {
        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_ALERTS_URL);

        alertsFormsWindowsAlertsPage.clickTimeAlertButton();

        Assert.assertEquals(alertsFormsWindowsAlertsPage.getTextFromTimerAlert(), "This alert appeared after 5 seconds");
    }

    @Test
    @DisplayName("Should be able to interact with alerts 3 - Select Cancel on confirm box")
    public void testAlertsFormsWindowsAlerts3() {
        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_ALERTS_URL);

        alertsFormsWindowsAlertsPage.clickConfirmButton();

        alertsFormsWindowsAlertsPage.clickCancelConfirm();

        Assert.assertTrue(alertsFormsWindowsAlertsPage.getConfirmResult().contains("You selected Cancel"));
    }

    @Test
    @DisplayName("Should be able to interact with alerts 4 - Select Ok on confirm box")
    public void testAlertsFormsWindowsAlerts4() {
        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_ALERTS_URL);

        alertsFormsWindowsAlertsPage.clickConfirmButton();

        alertsFormsWindowsAlertsPage.clickAcceptConfirm();

        Assert.assertTrue(alertsFormsWindowsAlertsPage.getConfirmResult().contains("You selected Ok"));
    }

    @Test
    @DisplayName("Should be able to interact with alerts 5 - Fill prompt box")
    public void testAlertsFormsWindowsAlerts5() {
        driver.get(Constants.TOOLS_QA_ALERTS_FORMS_WINDOWS_ALERTS_URL);

        alertsFormsWindowsAlertsPage.clickPromptButton();

        alertsFormsWindowsAlertsPage.sendKeysToAlert("Luiz Inácio Lula da Silva");

        alertsFormsWindowsAlertsPage.clickAcceptConfirm();

        Assert.assertTrue(alertsFormsWindowsAlertsPage.getPromptResult().contains("You entered Luiz Inácio Lula da Silva"));
    }

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
