package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class PopUpWindowPage extends BasePage<PopUpWindowPage> {
    public PopUpWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[id='login']")
    WebElement getOpenButton;

    @FindBy(css = "p[id='info']")
    WebElement getTextMainWindow;


    @Step("click o the button [OPEN]")
    public PopUpWindowPage clickOpenButton() {
        getOpenButton.click();

        return this;
    }

    @Step("get alert text")
    public PopUpWindowPage getAlert() {
        String parentWindowHandler = getDriver().getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

        wait5().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button")))).click();
        driver.switchTo().window(parentWindowHandler);  // switch back to parent window

        return this;


    }

    @Step
    public void assertTextMainWindow(String text) {

        Assert.assertEquals(getTextMainWindow.getText(), text);
    }

}
