package hw4;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiffElementPage {
    @FindBy(xpath = "//label[text()[contains(., ' Water')]]")
    public static WebElement water;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]")
    public static WebElement wind;

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]")
    public static WebElement selen;

    @FindBy(css = "select > option:nth-child(4)")
    public static WebElement yellow;

    @FindBy(xpath = "//*[contains(text(),'Water: condition changed to true')]")
    public WebElement logWater;

    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    public WebElement logWind;

    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    public WebElement logSelen;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    public WebElement logYellow;

//    public void clickWater(){
//        water.click();
//    }
//
//    public void clickWind(){
//        wind.click();
//    }
//
//    public void clickSelen(){
//        selen.click();
//    }
//
//    public void setYellow(){
//        yellow.click();
//    }
}
