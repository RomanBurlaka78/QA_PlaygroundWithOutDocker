package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.ShadowDomPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("MultiLevelDropDown")
@Owner("RomanB")
public class ShadowDomTest extends BaseTest {


    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetPercent() {
        String e = new MainPage(getDriver())
                .goToPage("Shadow DOM", new ShadowDomPage(getDriver()))
                .clickButton()
                .getShadowElement();
        System.out.println(e);
    }
}
