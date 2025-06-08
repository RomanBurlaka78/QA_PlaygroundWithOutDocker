package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RatingPage extends BasePage<RatingPage>{
    public RatingPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    @FindBy(css = "div[class ='stars'] label")
    List<WebElement> rates;


    @Step("click all")
    public void clickAll() {
        rates.forEach(WebElement::click);
    }


    @Step("click rating : {number}")
    public RatingPage clickRatingNumberIs(int number) {
        getDriver().findElement(By.cssSelector(String.format("div[class ='stars'] label[for='star-%s']", number))).click();

        return this;
    }

    @Step("emiji should be same as : {emoji}")
    public RatingPage emojiShouldBeSameAs(int emoji) {
        WebElement element = getDriver().findElement(By.cssSelector(String.format(
                "div[class='emojis'] li img[src='emojis/emoji-%s.png']",emoji)));

        assertThat(element.getAttribute("src").equals(String.format("src='emojis/emoji-%s.png'",emoji)));
        getDriver().findElement(By.cssSelector("span[class='numb']"));

        return this;

    }

    @Step("like of : {number}")
    public void numberOfContentShouldBe(int number) {

        String content = js.executeScript("return window.getComputedStyle(" +
                "document.querySelector('span.numb'), '::before'" +
                        ").getPropertyValue('content')").toString();
        String num[] = content.replaceAll("[^0-9 ]", "").split(" ");

        assertThat(num[0].equals(number));
    }
}
