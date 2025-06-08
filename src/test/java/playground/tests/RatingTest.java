package playground.tests;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.RatingPage;

public class RatingTest extends BaseTest {

    @Test
    public void testClickAllStars() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickAll();
    }

    @Test
    public void testClickRatingStarsNumber() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickRatingNumberIs(5)
                .emojiShouldBeSameAs(5);
    }

    @Test
    public void testGetRatingStarsNumber() {
        new MainPage(getDriver())
                .goToPage("Stars Rating Widget" , new RatingPage(getDriver()))
                .clickRatingNumberIs(4)
                .numberOfContentShouldBe(4);
    }
}
