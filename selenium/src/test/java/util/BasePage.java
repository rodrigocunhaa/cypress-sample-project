package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        action = new Actions(driver);
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void waitAndClear(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
    }

    public void waitAndDoubleClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.doubleClick(driver.findElement(locator)).perform();
    }

    public void waitAndRightClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.contextClick(driver.findElement(locator)).perform();
    }

    public void waitAndSendKeys(By locator, String keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(keys);
    }

    public void clickRadioButton(By button){
        WebElement radioButton = driver.findElement(button);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioButton);
    }

    public List<String> getAllTextFromElements (By locator) {
        List<String> allText = new ArrayList<>();

        for (WebElement element : driver.findElements(locator)){
            allText.add(element.getText());
        }
        return allText;
    }

    public void switchToTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void closeTabAndReturn() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void selectByValue(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public void uploadImage(By locator, String fileName) {
        File file = new File(fileName);
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void scrollUntilTheEnd() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isElementPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator).size() != 0;
    }
}