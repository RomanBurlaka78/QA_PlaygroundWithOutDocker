package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import playground.pages.MainPage;
import playground.pages.VerifyYourAccountPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;


@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("VerifyAccount")
@Owner("RomanB")
public class VerifyAccountTest extends BaseTest {


    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetTitle() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .titleShouldBeSameAs("Test Verify Account Flow");
    }

    @Test
    @Story("Verify : assert info success")
    @Severity(SeverityLevel.TRIVIAL)
    public void testShownInfoSuccess() {
        new MainPage(getDriver())
                .goToPage("Verify Your Account", new VerifyYourAccountPage(getDriver()))
                .enterConfirmationCode()
                .infoSuccessShouldBe("Success");
    }
}
