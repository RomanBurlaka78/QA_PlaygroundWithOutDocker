package playground.tests;

import playground.pages.MainPage;
import playground.pages.SortableListPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import java.util.List;

public class SortedListTest extends BaseTest {

    @Test
    public void testGetItem() {
        List<String> list = new MainPage(driver)
                .goToPage("Sortable List", new SortableListPage(getDriver()))
                .getTableSortedList();
        list.forEach(System.out::println);

    }
}
