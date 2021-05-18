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

public class TestAlertsFormsWindows {
    private WebDriver driver;
    private final AlertsFormsWindowsModalDialogsPage alertsFormsWindowsModalDialogsPage = new AlertsFormsWindowsModalDialogsPage();

    @Before
    public void before(){
        driver = DriverFactory.getDriver();
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

    @After
    public void after(){
        DriverFactory.quitDriver();
    }
}
