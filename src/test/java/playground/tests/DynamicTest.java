package playground.tests;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import playground.pages.DynamicTablePage;
import playground.pages.MainPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("DynamicTes")
@Owner("RomanB")
public class DynamicTest extends BaseTest {

    @Test
    @Story("Verify : TitleDynamicAppPage")
    @Severity(SeverityLevel.NORMAL)
    public void testGetTitleDynamicAppPage() throws InterruptedException {
        new MainPage(getDriver())
                .goToPage("Dynamic Table", new DynamicTablePage(getDriver()))
                .titleShouldBeSameAs("Test Dynamic Table");
    }


    @Test
    @Story("Verify : item name")
    @Severity(SeverityLevel.NORMAL)
    public void testGetItem() {
        String realName = new MainPage(getDriver())
                .goToPage("Dynamic Table", new DynamicTablePage(getDriver()))
                .superHeroShouldBeAs("Spider-Man")
                .realNameShouldBeAs("Peter Parker");

        Assert.assertEquals(realName, "Peter Parker");
    }

}
