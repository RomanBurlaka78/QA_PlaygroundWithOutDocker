package playground.tests;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.PopUpWindowPage;

public class PopUpWindowTest extends BaseTest {

    @Test
    public void testPopUpTitlePage() {
        new MainPage(getDriver())
                .goToPage("Pop-Up Window", new PopUpWindowPage(getDriver()))
                .titleShouldBeSameAs("Test PopUp");
    }

    @Test
    public void testPopUpText() {
        new MainPage(getDriver())
                .goToPage("Pop-Up Window", new PopUpWindowPage(getDriver()))
                .clickOpenButton()
                .getAlert()
                .assertTextMainWindow("Button Clicked");
    }
}
