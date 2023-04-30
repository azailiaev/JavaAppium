package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

@Epic("Welcome screen tests for iOS")
public class GetStartedTest extends CoreTestCase
{
    @Test
    @DisplayName("Pass welcome screen")
    @Step("Starting test 'testWelcomePass'")
    public void testWelcomePass()
    {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW()))
        {
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);
        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();
        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();
        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();
        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStartedButton();
    }
}
