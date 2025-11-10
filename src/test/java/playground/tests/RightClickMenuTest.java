package playground.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.RightClickMenuPage;

import java.util.ArrayList;
import java.util.List;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("RightClickMenu")
@Owner("RomanB")
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
    @Story("Verify : assert title")
    @Severity(SeverityLevel.NORMAL)
    public void testGetContextMenuItem() {
        String list = new MainPage(getDriver())
                .goToPage("Right-Click Context Menu", new RightClickMenuPage(getDriver()))
                .clickContextMenu()
                .getListOfContextMenu();

        Assert.assertEquals(list, List.of("Preview", "Get Link", "Rename", "Delete", "Setting"), "Not contains");

        System.out.println(list);
    }

    @Test(dataProvider = "getMenuItem")
    @Story("Verify : name and num")
    @Severity(SeverityLevel.NORMAL)
    public void testClickMenuItem(String name, int num) {
        String item = new MainPage(getDriver())
                .goToPage("Right-Click Context Menu", new RightClickMenuPage(getDriver()))
                .clickContextMenu()
                .menuItemClickedShouldBeAs(name, num);
    }



}

