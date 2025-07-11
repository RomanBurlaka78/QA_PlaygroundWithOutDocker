package playground.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.MultiLevelDropDownPage;

@Ignore
public class MultiLevelDropDownTest extends BaseTest {

    @Test
    public void testGetDropDownTitle() {
        new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .titleShouldBeSameAs("Test Multi Level Dropdown");
    }

    @Test
    public void testClickDropDownChooseItem() {
        String dropdownList = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Settings")
                .getDropdownList();

//        Assert.assertTrue(dropdownList.("My Tutorial, HTML, CSS, JavaScript, Awesome!"));
    }

    @Test
    public void testClickDropDownChooseOtherItem() {
        String dropdownList = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Animals")
                .getDropdownList();

//        Assert.assertTrue(dropdownList.("My Tutorial, HTML, CSS, JavaScript, Awesome!"));
    }

    @Test
    public void testContainsItemAs() {
        String dropdownItem = new MainPage(getDriver())
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage(getDriver()))
                .clickDropDownAndChooseItem("Animals")
                .dropdownListContains("Frog");
        System.out.println(dropdownItem);
    }
}
