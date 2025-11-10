package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.RatingPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("Rating")
@Owner("RomanB")
public class RatingTest extends BaseTest {

    @Test
    @Story("Verify : click all stars")
    @Severity(SeverityLevel.NORMAL)
    public void testClickAllStars() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickAll();
    }

    @Test
    @Story("Verify : click rating stars number")
    @Severity(SeverityLevel.NORMAL)
    public void testClickRatingStarsNumber() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickRatingNumberIs(5)
                .emojiShouldBeSameAs(5);
    }

    @Test
    @Story("Verify : rating number")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetRatingStarsNumber() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickRatingNumberIs(4)
                .numberOfContentShouldBe(4);
    }
}
