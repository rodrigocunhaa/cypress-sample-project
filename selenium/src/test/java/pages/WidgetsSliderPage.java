package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.BasePage;
import util.DriverFactory;

public class WidgetsSliderPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final By firstElementSlider = By.xpath("//input[@type='range']");
    private final By secondElementSlider = By.xpath("//div[contains(@class,'range-slider__tooltip--auto')]");
    private final By thirdElementSlider = By.xpath("//input[contains(@id,'sliderValue')]");

    public void move() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value='80'", driver.findElement(firstElementSlider));
        js.executeScript("arguments[0].setAttribute('style', '--value:80;')", driver.findElement(firstElementSlider));
        js.executeScript("arguments[0].setAttribute('value', '80')", driver.findElement(firstElementSlider));
        js.executeScript("arguments[0].setAttribute('style', 'left: calc(80% + -6px);')", driver.findElement(secondElementSlider));
        js.executeScript("arguments[0].setAttribute('value', '80')", driver.findElement(thirdElementSlider));

    }

    public String getValueFromSlider(){
        return driver.findElement(thirdElementSlider).getAttribute("value");
    }


}
