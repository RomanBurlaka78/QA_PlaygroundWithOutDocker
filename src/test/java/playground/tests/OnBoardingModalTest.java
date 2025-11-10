package playground.tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import playground.base.BaseTest;
import playground.pages.MainPage;
import playground.pages.OnBoardingModalPage;

@Listeners(playground.utils.TestListener.class)
@Epic("QA Playground Mini Web Apps")
@Feature("OnBoardingModal")
@Owner("RomanB")

public class OnBoardingModalTest extends BaseTest {
    @Test
    @Story("Verify : assert title")
    @Severity(SeverityLevel.TRIVIAL)
    public void testGetTitleOnBoardingPage() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .titleShouldBeSameAs("Test Onboarding Modal Flow");
    }
    @Test
    @Story("Verify : assert title of subTitle ")
    @Severity(SeverityLevel.TRIVIAL)
    public void testInnerSubTitleIsShown() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .clickBurgerMenu()
                .subTitleShownAs("Welcome on board!");
    }

    @Test
    @Story("Verify : assert title of subTitle ")
    @Severity(SeverityLevel.TRIVIAL)
    public void testCloseBurgerMenu() {
        new MainPage(getDriver())
                .goToPage("Onboarding Modal Popup", new OnBoardingModalPage(getDriver()))
                .clickBurgerMenu()
                .subTitleShownAs("Welcome on board!")
                .clickBurgerMenu();
    }
}
