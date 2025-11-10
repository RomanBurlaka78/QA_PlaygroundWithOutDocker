package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.PopUpWindowPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("PopUpWindow")
@Owner("RomanB")
public class PopUpWindowTest extends BaseTest {

    @Test
    @Story("Verify : assert title of subTitle ")
    @Severity(SeverityLevel.TRIVIAL)
    public void testPopUpTitlePage() {
        new MainPage(getDriver())
                .goToPage("Pop-Up Window", new PopUpWindowPage(getDriver()))
                .titleShouldBeSameAs("Test PopUp");
    }

    @Test
    @Story("Verify : pop up text ")
    @Severity(SeverityLevel.NORMAL)
    public void testPopUpText() {
        new MainPage(getDriver())
                .goToPage("Pop-Up Window", new PopUpWindowPage(getDriver()))
                .clickOpenButton()
                .getAlert()
                .assertTextMainWindow("Button Clicked");
    }
}
