package playground.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.MouseHoverPage;
import playground.pages.MultiLevelDropDownPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("MultiLevelDropDown")
@Owner("RomanB")
public class MultiLevelDropDownTest extends BaseTest {

    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetDropDownTitle() {
        new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .titleShouldBeSameAs("Test Multi Level Dropdown");
    }

    @Test
    @Story("Verify : DropDownChooseItem")
    @Severity(SeverityLevel.NORMAL)
    public void testClickDropDownChooseItem() {
        String dropdownList = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Settings")
                .getDropdownList();
    }

    @Test
    @Story("Verify : DropDownChooseAnotherItem")
    @Severity(SeverityLevel.NORMAL)
    public void testClickDropDownChooseOtherItem() {
        String dropdownList = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Animals")
                .getDropdownList();

    }

    @Test
    @Story("Verify : assert items name")
    @Severity(SeverityLevel.NORMAL)
    public void testContainsItemAs() {
        String dropdownItem = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Animals")
                        .getDropdownList();
//                .dropdownListContains("Horse");
        System.out.println(dropdownItem);
    }
}

