package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class WidgetsMenu {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By menuItem1 = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Main Item 1')]");
    private final By menuItem2 = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Main Item 2')]");
    private final By menuItem3 = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Main Item 3')]");
    private final By menuSubItem = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Sub Item')]");
    private final By menuSubSubList = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'SUB SUB LIST')]");
    private final By menuSubItem1 = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Sub Item 1')]");
    private final By menuSubItem2 = By.xpath("//div[@class='nav-menu-container']//a[contains(text(),'Sub Item 2')]");

    public boolean isMenuItem1Visible() {
        return driver.findElement(menuItem1).isDisplayed();
    }

    public boolean isMenuItem2Visible() {
        return driver.findElement(menuItem2).isDisplayed();
    }

    public boolean isMenuItem3Visible() {
        return driver.findElement(menuItem3).isDisplayed();
    }

    public boolean isSubItemVisible() {
        return driver.findElement(menuSubItem).isDisplayed();
    }

    public boolean isSubSubListVisible() {
        return driver.findElement(menuSubSubList).isDisplayed();
    }

    public boolean isMenuSubItem1Visible() {
        return driver.findElement(menuSubItem1).isDisplayed();
    }

    public boolean isMenuSubItem2Visible() {
        return driver.findElement(menuSubItem2).isDisplayed();
    }

    public void mouseOverMenuItem2() {
        page.mouseOverElement(menuItem2);
    }

    public void mouseOverSubSubList() {
        page.mouseOverElement(menuSubSubList);
    }
}
