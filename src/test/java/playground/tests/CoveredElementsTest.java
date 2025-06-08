package playground.tests;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.CoveredElementsPage;
import playground.pages.MainPage;

public class CoveredElementsTest extends BaseTest {

    @Test
    public void testScrollAndClickButton() {
        new MainPage(getDriver())
                .goToPage("Covered Elements", new CoveredElementsPage(getDriver()))
                .scrollToButtonBelow()
                .textShouldBeSameAs("Mission accomplished");

    }
}
