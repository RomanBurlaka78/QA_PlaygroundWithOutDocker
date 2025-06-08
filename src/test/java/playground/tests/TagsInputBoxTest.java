package playground.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.TagInputBoxPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    public void testGetPageTitle() {
        new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .titleShouldBeSameAs("Test Tags Input Box");

    }

    @Test(dataProvider = "dataNames")
    public void testAddTag(String dataNames) {
        new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .addTag(dataNames);


    }

    @Test
    public void testRemainingTags() {
        int number = new MainPage(getDriver())
                .goToPage("Tags Input Box", new TagInputBoxPage(getDriver()))
                .addSeveralTags("Darek, Franek, Ola, Dawid")
                .tagsRemaining();

        Assert.assertEquals(number, 4);





    }

}
