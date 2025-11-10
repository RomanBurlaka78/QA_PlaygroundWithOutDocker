package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.CoveredElementsPage;
import playground.pages.MainPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("CoveredElements")
@Owner("RomanB")
public class CoveredElementsTest extends BaseTest {

    @Test
    @Story("Verify action: scroll and click button")
    @Severity(SeverityLevel.NORMAL)
    public void testScrollAndClickButton() {
        new MainPage(getDriver())
                .goToPage("Covered Elements", new CoveredElementsPage(getDriver()))
                .scrollToButtonBelow()
                .textShouldBeSameAs("Mission accomplished");

    }
}
