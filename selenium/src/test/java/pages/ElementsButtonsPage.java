package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class ElementsButtonsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By doubleClickButton = By.xpath("//button[@id='doubleClickBtn']");
    private final By doubleClickMessage = By.xpath("//p[@id='doubleClickMessage']");
    private final By rightClickButton = By.xpath("//button[@id='rightClickBtn']");
    private final By rightClickMessage = By.xpath("//p[@id='rightClickMessage']");
    private final By clickMeButton = By.xpath("//button[@type='button' and (text()='Click Me')]");
    private final By clickMeMessage = By.xpath("//p[@id='dynamicClickMessage']");


    public String getDoubleClickMessage() {
        return driver.findElement(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return driver.findElement(rightClickMessage).getText();
    }

    public String getClickMeMessage() {
        return driver.findElement(clickMeMessage).getText();
    }

    public void clickOnDoubleClickButton() {
        page.waitAndDoubleClick(doubleClickButton);
    }

    public void clickOnRightClickButton() {
        page.waitAndRightClick(rightClickButton);
    }

    public void clickOnClickMeButton() {
        page.waitAndClick(clickMeButton);
    }

}
