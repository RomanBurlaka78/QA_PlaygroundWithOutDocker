package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnBoardingModalPage extends  BasePage<OnBoardingModalPage>{
    public OnBoardingModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "label[class='menu-btn']")
    WebElement burgerMenu;

    @FindBy(css = "div[class ='wrapper'] ul li a")
    WebElement innerSubTitle;
    @FindBy(css = "div[class ='title']")
    WebElement titleCenter;


    @Step("click burger menu")
    public OnBoardingModalPage clickBurgerMenu() {
        burgerMenu.click();
        return this;
    }

    @Step("subtitle is shown : {subTitle}")
    public OnBoardingModalPage subTitleShownAs(String subTitle) {
        innerSubTitle.isDisplayed();
        Assert.assertEquals(innerSubTitle.getText(),subTitle);

        return this;
    }
    @Step("title in center should be as: {titleCenter}")
    public OnBoardingModalPage titleCenterShouldBeAs(String title) {

        Assert.assertEquals(innerSubTitle.getText(), title);

        return this;
    }

}
