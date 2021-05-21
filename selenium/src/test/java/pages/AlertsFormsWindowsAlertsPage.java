package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePage;
import util.DriverFactory;

public class AlertsFormsWindowsAlertsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = DriverFactory.getWait();
    private final BasePage page = new BasePage(driver);
    private final By alertButton = By.xpath("//button[@id='alertButton']");
    private final By timeAlertButton = By.xpath("//button[@id='timerAlertButton']");
    private final By confirmButton = By.xpath("//button[@id='confirmButton']");
    private final By confirmResult = By.xpath("//span[@id='confirmResult']");
    private final By promptButton = By.xpath("//button[@id='promtButton']");
    private final By promptResult = By.xpath("//span[@id='promptResult']");

    public void sendKeysToAlert (String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void clickCancelConfirm() {
        driver.switchTo().alert().dismiss();
    }

    public void clickAcceptConfirm() {
        driver.switchTo().alert().accept();
    }

    public String getConfirmResult() {
        return driver.findElement(confirmResult).getText();
    }

    public String getPromptResult() {
        return driver.findElement(promptResult).getText();
    }

    public String getTextFromTimerAlert() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.switchTo().alert().getText();
    }

    public void clickAlertButton() {
        page.waitAndClick(alertButton);
    }

    public void clickTimeAlertButton() {
        page.waitAndClick(timeAlertButton);
    }

    public void clickConfirmButton() {
        page.waitAndClick(confirmButton);
    }

    public void clickPromptButton() {
        page.waitAndClick(promptButton);
    }


}
