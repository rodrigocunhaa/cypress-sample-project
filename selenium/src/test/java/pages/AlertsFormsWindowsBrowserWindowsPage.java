package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePage;
import util.DriverFactory;

public class AlertsFormsWindowsBrowserWindowsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = DriverFactory.getWait();
    private final BasePage page = new BasePage(driver);
    private final By tabButton = By.xpath("//button[@id='tabButton']");
    private final By windowButton = By.xpath("//button[@id='windowButton']");
    private final By messageWindowButton = By.xpath("//button[@id='messageWindowButton']");
    private final By tabWindow = By.xpath("//h1[@id='sampleHeading']");
    private final By messageWindow = By.xpath("//body");

    public void clickTabButton () {
        page.waitAndClick(tabButton);
    }

    public void clickWindowButton () {
        page.waitAndClick(windowButton);
    }

    public void clickMessageWindowButton () {
        page.waitAndClick(messageWindowButton);
    }

    public String getTabWindowText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabWindow));
        return driver.findElement(tabWindow).getText();
    }

    public boolean isBodyPresent() {
        return driver.findElement(By.tagName("body")) != null;
    }

}
