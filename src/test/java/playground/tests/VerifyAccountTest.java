package playground.tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import playground.pages.MainPage;
import playground.pages.VerifyYourAccountPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;


public class VerifyAccountTest extends BaseTest {
    MainPage mainPage = new MainPage(getDriver());


    @Test
    public void testGetTitle() {
        mainPage
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
