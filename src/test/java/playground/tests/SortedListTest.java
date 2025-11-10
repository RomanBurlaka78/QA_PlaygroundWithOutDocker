package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import playground.pages.MainPage;
import playground.pages.SortableListPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import java.util.List;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("MultiLevelDropDown")
@Owner("RomanB")
public class SortedListTest extends BaseTest {

    @Test
    @Story("Verify : assert item title")
    @Severity(SeverityLevel.NORMAL)
    public void testGetItem() {
        List<String> list = new MainPage(driver)
                .goToPage("Sortable List", new SortableListPage(getDriver()))
                .getTableSortedList();
        list.forEach(System.out::println);

    }

    @Test
    @Story("Verify : sort list")
    @Severity(SeverityLevel.TRIVIAL)
    public void testSortList() {
        List<String> list = new MainPage(driver)
                .goToPage("Sortable List", new SortableListPage(getDriver()))
                .sortList()
                        .getTableSortedList();
        list.forEach(System.out::println);
    }
}
