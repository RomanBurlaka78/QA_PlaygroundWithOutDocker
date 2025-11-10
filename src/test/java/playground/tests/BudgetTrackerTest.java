package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.BudgetTrackerPage;
import playground.pages.MainPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("BudgetTracker")
@Owner("RomanB")
public class BudgetTrackerTest extends BaseTest {

    @Test
    @Story("Verify : Add record")
    @Severity(SeverityLevel.NORMAL)
    public void testAddRecord() {
        new MainPage(getDriver())
                .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                .addNewEntry("01012025 ", "description of the element", "34213");
    }

    @Test
    @Story("Verify : Delete record")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteRecord() {
        new MainPage(getDriver())
                .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                .addNewEntry("01012025 ", "description of the element", "34213")
                .totalShouldBe("000");
    }
}
