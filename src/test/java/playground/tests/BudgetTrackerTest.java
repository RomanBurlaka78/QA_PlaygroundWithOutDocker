package playground.tests;
import io.qameta.allure.*;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.BudgetTrackerPage;
import playground.pages.MainPage;

@Epic("Playground")
@Feature("BudgetTracker")
public class BudgetTrackerTest extends BaseTest {

    @Test
    @Story("Record")
    @Severity(SeverityLevel.NORMAL)
    public void testAddRecord() {
        Allure.step("Add record", ()-> {
            new MainPage(getDriver())
                    .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                    .addNewEntry("01012025 ", "description of the element", "34213");
        });

    }

    @Test
    @Story("Record")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteRecord() {
       new MainPage(getDriver())
                .goToPage("Budget Tracker", new BudgetTrackerPage(getDriver()))
                .addNewEntry("01012025 ", "description of the element", "34213")
                .totalShouldBe("000");
    }
}
