package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

public class WidgetsAccordianPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By whatIsLoremIpsumTitle = By.xpath("//div[@id='section1Heading']");
    private final By whatIsLoremIpsumCollapse_showFlag = By.xpath("//div[@id='section1Heading']/following-sibling::div[@class = 'collapse show']");
    private final By whatIsLoremIpsumCollapse_collapsedFlag = By.xpath("//div[@id='section1Heading']/following-sibling::div[@class = 'collapse']");
    private final By whatIsLoremIpsumText = By.xpath("//div[@id='section1Content']");
    private final By whereDoesItComeFromTitle = By.xpath("//div[@id='section2Heading']");
    private final By whereDoesItComeFrom_showFlag = By.xpath("//div[@id='section2Heading']/following-sibling::div[@class = 'collapse show']");
    private final By whereDoesItComeFrom_collapsedFlag = By.xpath("//div[@id='section2Heading']/following-sibling::div[@class = 'collapse']");
    private final By whereDoesItComeFromText = By.xpath("//div[@id='section2Content']");
    private final By whyDoWeUseItTitle = By.xpath("//div[@id='section3Heading']");
    private final By whyDoWeUseIt_showFlag = By.xpath("//div[@id='section3Heading']/following-sibling::div[@class = 'collapse show']");
    private final By whyDoWeUseIt_showCollapsedFlag = By.xpath("//div[@id='section3Heading']/following-sibling::div[@class = 'collapse']");
    private final By whyDoWeUseItText = By.xpath("//div[@id='section3Content']");

    public String getWhatIsLoremIpsumTitleText() {
        return driver.findElement(whatIsLoremIpsumTitle).getText();
    }

    public String getWhatIsLoremIpsumText() {
        return driver.findElement(whatIsLoremIpsumText).getText();
    }

    public String getWhereDoesItComeFromTitleText() {
        return driver.findElement(whereDoesItComeFromTitle).getText();
    }

    public String getWhereDoesItComeFromText() {
        return driver.findElement(whereDoesItComeFromText).getText();
    }

    public String getWhyDoWeUseItTitleText() {
        return driver.findElement(whyDoWeUseItTitle).getText();
    }

    public String getWhyDoWeUseItText() {
        return driver.findElement(whyDoWeUseItText).getText();
    }

    public boolean isWhatIsLoremIpsumCollapsedFlag() {
        return page.isElementPresent(whatIsLoremIpsumCollapse_collapsedFlag);
    }

    public boolean isWhatIsLoremIpsumShownFlag() {
        return page.isElementPresent(whatIsLoremIpsumCollapse_showFlag);
    }

    public boolean isWhereDoesItComeFromCollapsedFlag() {
        return page.isElementPresent(whereDoesItComeFrom_collapsedFlag);
    }

    public boolean isWhereDoesItComeFromShownFlag() {
        return page.isElementPresent(whereDoesItComeFrom_showFlag);
    }

    public boolean isWhyDoWeUseItCollapsedFlag() {
        return page.isElementPresent(whyDoWeUseIt_showCollapsedFlag);
    }

    public boolean isWhyDoWeUseItShownFlag() {
        return page.isElementPresent(whyDoWeUseIt_showFlag);
    }

    public void clickWhereDoesItComeFromTitle() {
        page.waitAndClick(whereDoesItComeFromTitle);
    }

    public void clickWhyDoWeUseItTitle() {
        page.waitAndClick(whyDoWeUseItTitle);
    }
}


