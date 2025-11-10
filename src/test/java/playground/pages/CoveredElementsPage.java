package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CoveredElementsPage extends  BasePage<CoveredElementsPage>{
    public CoveredElementsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "fugitive")
    WebElement buttonBellow;

    @FindBy(css = "p[id='info']")
    WebElement paragraph;


    @Step("scroll page and click button bellow")
    public CoveredElementsPage scrollToButtonBelow(){
        getActions().clickAndHold(getDriver().findElement(By.cssSelector("div[class = 'wrapper']")))
                .scrollToElement(buttonBellow).click(buttonBellow).perform();

        return this;

    }
    @Step("text of paragraph shouldBe : {info}")
    public void textShouldBeSameAs(String  info) {
        Assert.assertEquals(paragraph.getText(),info);
    }


}
