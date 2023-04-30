package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArcticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "css:#content h1";
        FIRST_TITLE_IN_LIST = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li:nth-child(3) > a > h3";
        SECOND_TITLE_IN_LIST = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li:nth-child(2) > a > h3";
        THIRD_TITLE_IN_LIST = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li:nth-child(6) > a > h3";
        FOOTER_ELEMENT = "css:footer";
        OPTION_ADD_TO_LIST = "xpath://*[@id='ca-watch']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SAVED_BUTTON = "xpath://XCUIElementTypeButton[@name='Saved']";
        SYNC_CROSS = "id:Close";
    }

    public MWArcticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
