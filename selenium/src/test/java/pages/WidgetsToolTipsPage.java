package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.BasePage;
import util.DriverFactory;

public class WidgetsToolTipsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);

    private final By hoverMeToSeeButton = By.xpath("//button[@id='toolTipButton']");
    private final By textField = By.xpath("//input[@id='toolTipTextField']");
    private final By contraryText = By.xpath("(//div[@id='texToolTopContainer']//a)[1]");
    private final By numberText = By.xpath("(//div[@id='texToolTopContainer']//a)[2]");

    public String getHoverMeToSeeButtonToolTipText() {
        page.mouseOverElement(hoverMeToSeeButton);
        return driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
    }

    public String getTextFieldToolTipText() {
        page.mouseOverElement(textField);
        return driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
    }

    public String getContraryTextToolTipText() {
        page.mouseOverElement(contraryText);
        return driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
    }

    public String getNumberTextToolTipText() {
        page.mouseOverElement(numberText);
        return driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
    }
}
