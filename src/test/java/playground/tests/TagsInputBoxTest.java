package playground.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.TagInputBoxPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("TagsInputBox")
@Owner("RomanB")
public class TagsInputBoxTest extends BaseTest {

    @DataProvider
    public static Object[] dataNames() {
        return new Object[][]{
                {"tag"},
                {"bag"},
                {"wag"},
                {"chmagedron"},
                {"xyz"}
        };
    }

    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetPageTitle() {
        new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .titleShouldBeSameAs("Test Tags Input Box");

    }

    @Test(dataProvider = "dataNames")
    @Story("Verify : assert add tag {dataNames}")
    @Severity(SeverityLevel.NORMAL)
    public void testAddTag(String dataNames) {
        new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .addTag(dataNames);
    }

    @Test
    @Story("Verify : assert remaining tags")
    @Severity(SeverityLevel.TRIVIAL)
    public void testRemainingTags() {
        int number = new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .addSeveralTags("Darek, Franek, Ola, Dawid")
                .tagsRemaining();

        Assert.assertEquals(number, 4);
    }
}
