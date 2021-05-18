package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePage;
import util.DriverFactory;

public class AlertsFormsWindowsModalDialogsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = DriverFactory.getWait();
    private final BasePage page = new BasePage(driver);
    private final By smallDialogButton = By.xpath("//button[@id='showSmallModal']");
    private final By closeSmallDialogButton = By.xpath("//button[@id='closeSmallModal']");
    private final By largeDialogButton = By.xpath("//button[@id='showLargeModal']");
    private final By closeLargeDialogButton = By.xpath("//button[@id='closeLargeModal']");
    private final By modalText = By.xpath("//div[@class='modal-body']");

    public void openSmallDialog() {
        page.waitAndClick(smallDialogButton);
    }

    public void openLargeDialog() {
        page.waitAndClick(largeDialogButton);
    }

    public void closeSmallDialog() {
        page.waitAndClick(closeSmallDialogButton);
    }

    public void closeLargeDialog() {
        page.waitAndClick(closeLargeDialogButton);
    }

    public String getModalText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalText));
        return driver.findElement(modalText).getText();
    }
}
