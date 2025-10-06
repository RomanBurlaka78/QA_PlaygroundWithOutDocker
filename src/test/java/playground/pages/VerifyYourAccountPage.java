package playground.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VerifyYourAccountPage extends BasePage<VerifyYourAccountPage> {
    public VerifyYourAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "small[class='info']")
    WebElement confirmationCode;

    @FindBy(css = "small[class='info success']")
    WebElement infoSuccess;

    @FindBy(css = "div[class='code-container'] input")
    List<WebElement> inputsCode;

    @Step("get confirmation code")
    public String getConfirmationCode() {
        return confirmationCode.getText().replaceAll("[^0-9]", " ");
    }

    @Step("enter confirmation code")
    public VerifyYourAccountPage enterConfirmationCode() {
        String code = confirmationCode.getText().replaceAll("[^0-9]", " ");
        waitForPageToLoad();
        inputsCode
                .forEach(element -> element.sendKeys(code));

        return this;
    }
    @Step("info success is shown : {message}")
    public void infoSuccessShouldBe(String message) {

        assertThat(wait5().until(ExpectedConditions.visibilityOf(infoSuccess)).getText().equals(message));
    }
}
