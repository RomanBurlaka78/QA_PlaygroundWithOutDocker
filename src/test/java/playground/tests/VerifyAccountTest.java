package playground.tests;

import playground.pages.MainPage;
import playground.pages.VerifyYourAccountPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;


public class VerifyAccountTest extends BaseTest {


    @Test
    public void testGetTitle() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .titleShouldBeSameAs("Test Verify Account Flow");
    }

    @Test
    public void testShownInfoSuccess() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .enterConfirmationCode()
                .infoSuccessShouldBe("Success");
    }
}
