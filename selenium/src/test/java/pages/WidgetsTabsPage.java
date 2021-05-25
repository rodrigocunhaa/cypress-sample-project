package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;
import util.DriverFactory;

import java.util.ArrayList;

public class WidgetsTabsPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final BasePage page = new BasePage(driver);
    private final By demoTabWhat = By.xpath("//a[@id='demo-tab-what']");
    private final By demoTabOrigin = By.xpath("//a[@id='demo-tab-origin']");
    private final By demoTabUse = By.xpath("//a[@id='demo-tab-use']");
    private final By demoTabMore = By.xpath("//a[@id='demo-tab-more']");
    private final By demoTabPaneWhat = By.xpath("//div[@id='demo-tabpane-what']");
    private final By demoTabPaneOrigin = By.xpath("//div[@id='demo-tabpane-origin']");
    private final By demoTabPaneUse = By.xpath("//div[@id='demo-tabpane-use']");
    private final By demoTabPaneMore = By.xpath("//div[@id='demo-tabpane-more']");

    public ArrayList<String> getDemoTabWhatAttributes() {
        String textAttr = driver.findElement(demoTabWhat).getText();
        String ariaSelected = driver.findElement(demoTabWhat).getAttribute("aria-selected");
        String classValue = driver.findElement(demoTabWhat).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(textAttr);
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabOriginAttributes() {
        String textAttr = driver.findElement(demoTabOrigin).getText();
        String ariaSelected = driver.findElement(demoTabOrigin).getAttribute("aria-selected");
        String classValue = driver.findElement(demoTabOrigin).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(textAttr);
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabUseAttributes() {
        String textAttr = driver.findElement(demoTabUse).getText();
        String ariaSelected = driver.findElement(demoTabUse).getAttribute("aria-selected");
        String classValue = driver.findElement(demoTabUse).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(textAttr);
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabMoreAttributes() {
        String textAttr = driver.findElement(demoTabMore).getText();
        String ariaSelected = driver.findElement(demoTabMore).getAttribute("aria-selected");
        String classValue = driver.findElement(demoTabMore).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(textAttr);
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public String getDemoTabPanelWhatText(){
        return driver.findElement(demoTabPaneWhat).getText();
    }

    public String getDemoTabPanelOriginText(){
        return driver.findElement(demoTabPaneOrigin).getText();
    }

    public String getDemoTabPanelUseText(){
        return driver.findElement(demoTabPaneUse).getText();
    }

    public String getDemoTabPanelMoreText(){
        return driver.findElement(demoTabPaneMore).getText();
    }

    public ArrayList<String> getDemoTabPaneWhatAttributes() {
        String ariaSelected = driver.findElement(demoTabPaneWhat).getAttribute("aria-hidden");
        String classValue = driver.findElement(demoTabPaneWhat).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabPaneOriginAttributes() {
        String ariaSelected = driver.findElement(demoTabPaneOrigin).getAttribute("aria-hidden");
        String classValue = driver.findElement(demoTabPaneOrigin).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabPaneUseAttributes() {
        String ariaSelected = driver.findElement(demoTabPaneUse).getAttribute("aria-hidden");
        String classValue = driver.findElement(demoTabPaneUse).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public ArrayList<String> getDemoTabPaneMoreAttributes() {
        String ariaSelected = driver.findElement(demoTabPaneMore).getAttribute("aria-hidden");
        String classValue = driver.findElement(demoTabPaneMore).getAttribute("class");

        ArrayList<String> listOfAttributes = new ArrayList<>();
        listOfAttributes.add(ariaSelected);
        listOfAttributes.add(classValue);

        return listOfAttributes;
    }

    public void clickDemoTabWhat() {
        page.waitAndClick(demoTabWhat);
    }

    public void clickDemoTabOrigin() {
        page.waitAndClick(demoTabOrigin);
    }

    public void clickDemoTabUse() {
        page.waitAndClick(demoTabUse);
    }

    public void clickDemoTabMore() {
        page.waitAndClick(demoTabMore);
    }

}
