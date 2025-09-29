package playground.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.RightClickMenuPage;

import java.util.List;

public class RightClickMenuTest extends BaseTest {

    @DataProvider
    public Object[][] getMenuItem() {
        return new Object[][]{
                {"Preview", 0},
                {"Get Link", 5},
                {"Rename", 6},
                {"Delete", 7},
                {"Settings", 8}
        };
    }

    @Test
    public void testGetContextMenuItem() {
        String list = new MainPage(getDriver())
                .goToPage("Right-Click Context Menu", new RightClickMenuPage(getDriver()))
                .clickContextMenu()
                .getListOfContextMenu();

        System.out.println(list);
    }

    @Test(dataProvider = "getMenuItem")
    public void testClickMenuItem(String name, int num) {
        String item = new MainPage(getDriver())
                .goToPage("Right-Click Context Menu", new RightClickMenuPage(getDriver()))
                .clickContextMenu()
                .menuItemClickedShouldBeAs(name, num);

    }



}

