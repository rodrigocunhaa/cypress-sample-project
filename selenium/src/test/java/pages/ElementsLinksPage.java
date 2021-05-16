package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class ElementsLinksPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By simpleLink = By.xpath("//a[@id='simpleLink']");
    private final By dynamicLink = By.xpath("//a[@id='dynamicLink']");

    public void clickSimpleLink(){
        page.waitAndClick(simpleLink);
    }

    public void clickDynamicLink(){
        page.waitAndClick(dynamicLink);
    }

}
