package playground.tests;

import playground.pages.MainPage;
import org.testng.annotations.Test;
import playground.base.BaseTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PlayGroundMainTest extends BaseTest {

    @Test
    public void testMainPage() {
        new MainPage(getDriver())
                .titleShouldBeSameAs("Playground for the QA automation engineers");

    }

}
