package playground.tests;

import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.OnBoardingModalPage;

public class OnBoardingModalTest extends BaseTest {
    @Test
    public void testGetTitleOnBoardingPage() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .titleShouldBeSameAs("Test Onboarding Modal Flow");
    }
    @Test
    public void testInnerSubTitleIsSown() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .clickBurgerMenu()
                .subTitleShownAs("Welcome on board!");
    }

    @Test
    public void testCloseBurgerMenu() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .clickBurgerMenu()
                .subTitleShownAs("Welcome on board!")
                .clickBurgerMenu();
//                .titleCenterShouldBeAs("Application successfully launched!");

    }
}
