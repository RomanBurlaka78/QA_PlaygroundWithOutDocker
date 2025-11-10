package playground.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.MouseHoverPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("MouseHover")
@Owner("RomanB")
public class MouseHoverTest extends BaseTest {

    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.NORMAL)
    public void testAssertTitle() {
        new MainPage(getDriver())
                .goToPage("Mouse Hover", new MouseHoverPage(getDriver()))
                .titleShouldBeSameAs("Test mouse hover/over");
    }

    @Test
    @Story("Verify : assert mouse hover price")
    @Severity(SeverityLevel.NORMAL)
    public void testAssertMouseHoverPrice() {
       String price =  new MainPage(getDriver())
                .goToPage("Mouse Hover", new MouseHoverPage(getDriver()))
                .getPrice();

        Assert.assertEquals(price, "$24.96");
    }
}
