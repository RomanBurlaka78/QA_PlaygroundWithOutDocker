package playground.tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Ignore;
import playground.pages.MainPage;
import playground.pages.VerifyYourAccountPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Ignore
public class VerifyAccountTest extends BaseTest {
    MainPage mainPage = new MainPage(getDriver());


    @Test
    public void testGetTitle() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .titleShouldBeSameAs("Test Verify Account Flow");

    }

    @Test
    public void testEnterTheCode() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .enterConfirmationCode();

    }


    @Test
    public void testShownInfoSuccess() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .enterConfirmationCode()
                .infoSuccessShouldBe("Success");

    }
}
