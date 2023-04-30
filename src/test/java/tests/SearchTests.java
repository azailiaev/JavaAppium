package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

@Epic("Search tests")
public class SearchTests extends CoreTestCase
{
    @Test
    @DisplayName("Search field input")
    @Step("Starting test 'testSendKeys'")
    public void testSendKeys()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    @DisplayName("Cancel search")
    @Step("Starting test 'testCancelSearch'")
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @DisplayName("Amount of not empty search")
    @Step("Starting test 'testAmountOfNotEmptySearch'")
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue(
                "We found to few results",
                amount_of_search_results > 0
        );
    }

    @Test
    @DisplayName("Amount of empty search")
    @Step("Starting test 'testAmountOfEmptySearch'")
    public void testAmountOfEmptySearch()
    {
        String search_line2 = "sdjkhhvfkjdfbkdfngbjkfd";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "sdjkhhvfkjdfbkdfngbjkfd";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    @DisplayName("Find articles then clear search field")
    @Step("Starting test 'testFindArticlesThenClearSearchField'")
    public void testFindArticlesThenClearSearchField()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title1 = ArticlePageObject.getFirstArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "Java (programming language)",
                article_title1
        );
        String article_title2 = ArticlePageObject.getSecondArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "JavaScript",
                article_title2
        );
        String article_title3 = ArticlePageObject.getThirdArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "Java (software platform)",
                article_title3
        );
        SearchPageObject.waitForElementAndClick("css:body > div.mw-overlays-container > div > div.overlay-header-container.header-container.header-chrome.position-fixed > div > div.header-action > button", "Error", 5);
        Platform.getInstance().isAndroid();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    @DisplayName("Search by title and description")
    @Step("Starting test 'testSearchByTitleAndDescription'")
    public void testSearchByTitleAndDescription() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title1 = ArticlePageObject.getFirstArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "Java (programming language)",
                article_title1
        );
        String article_title2 = ArticlePageObject.getSecondArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "JavaScript",
                article_title2
        );
        String article_title3 = ArticlePageObject.getThirdArticleTitleInList();
        Assert.assertEquals(
                "Article title not found",
                "Java (software platform)",
                article_title3
        );
    }
}
