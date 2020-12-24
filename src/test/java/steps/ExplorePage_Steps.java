package steps;

import helper.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Explore_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 22:00
 */
public class ExplorePage_Steps {

    final Explore_Page explore_page = new Explore_Page(Driver.current());

    @Then("I Swipe left to “Series” section")
    public void i_swipe_left_to_series_section() {
        explore_page.setSearchBar();
        explore_page.setBarScroll();
    }


    @Then("I Search for “Harry”")
    public void i_search_for_harry() {
        explore_page.setAutomcompleatebar("Harry");

    }

    @Then("I Swipe up on search result to find “Advantures of Harry Stevenson” and click on it")
    public void i_swipe_up_on_search_result_to_find_advantures_of_harry_stevenson_and_click_on_it() {
        explore_page.goBack();
        explore_page.clickSearchResult();

    }

    @Then("I Verify that page is the correct page")
    public void i_verify_that_page_is_the_correct_page() {

        Assert.assertEquals(explore_page.getTitle(), "Adventures of Harry Stevenson");
        System.out.println("Page Verify will be implemented");

    }

    @Then("I Click Filter")
    public void i_click_filter() {
        explore_page.clickFilterBtn();

    }

    @Then("I Remove Ebook from Filter list and click “Done”")
    public void i_remove_ebook_from_filter_list_and_click_done() {
        explore_page.setEbookCheckBtn();
        explore_page.clickDoneBtn();

    }

    @Then("I Verify “Oops! It seems you've filtered a bit too much.” text on the screen.")
    public void i_verify_oops_it_seems_you_ve_filtered_a_bit_too_much_text_on_the_screen() {
        Assert.assertEquals(explore_page.getFilterErrorMessage(), "Oops! It seems you've filtered a bit too much.");


    }
}
