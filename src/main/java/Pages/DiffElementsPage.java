package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiffElementsPage {
    @FindBy(xpath = "//label[text()[contains(., ' Water')]]")
    public WebElement water;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]")
    public WebElement wind;

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]")
    public WebElement selen;

    @FindBy(css = "select > option:nth-child(4)")
    public WebElement yellow;

    @FindBy(xpath = "//*[contains(text(),'Water: condition changed to true')]")
    public WebElement logWater;

    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    public WebElement logWind;

    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    public WebElement logSelen;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    public WebElement logYellow;

    public void clickWater(){
        water.click();
    }

    public void clickWind(){
        wind.click();
    }

    public void clickSelen(){
        selen.click();
    }

    public void setYellow(){
        yellow.click();
    }
}
