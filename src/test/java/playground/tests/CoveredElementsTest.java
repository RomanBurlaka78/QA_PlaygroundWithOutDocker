package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.BudgetTrackerPage;
import playground.pages.CoveredElementsPage;
import playground.pages.MainPage;

@Epic("Playground")
@Feature("CoveredElements")
public class CoveredElementsTest extends BaseTest {

    @Test
    @Story("ScrollAndClickButton")
    @Severity(SeverityLevel.NORMAL)
    public void testScrollAndClickButton() {
        Allure.step("Scroll and find covered element", () -> {
            String paragraph =  new MainPage(getDriver())
                    .goToPage("Covered Elements", new CoveredElementsPage(getDriver()))
                    .scrollToButtonBelow()
                    .textOfParagraph("Mission accomplished");

            softAssert().assertEquals(paragraph, "Mission accomplished");
            Allure.addAttachment("paragraph name: ", paragraph);

        });


    }
}