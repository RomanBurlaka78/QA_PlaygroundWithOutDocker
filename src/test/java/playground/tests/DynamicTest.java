package playground.tests;


import org.testng.Assert;
import org.testng.annotations.Ignore;
import playground.pages.DynamicTablePage;
import playground.pages.MainPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Ignore
public class DynamicTest extends BaseTest {

    @Test
    public void testGetTitleDynamicAppPage() throws InterruptedException {
        new MainPage(getDriver())
                .goToPage("Dynamic Table", new DynamicTablePage(getDriver()))
                .titleShouldBeSameAs("Test Dynamic Table");

    }


    @Test
    public void testGetItem() {
        String realName = new MainPage(getDriver())
                .goToPage("Dynamic Table", new DynamicTablePage(getDriver()))
                .superHeroShouldBeAs("Spider-Man")
                .realNameShouldBeAs("Peter Parker");

        Assert.assertEquals(realName, "Peter Parker");

    }

    @Test
    public  void testCountName() {
    }






}
