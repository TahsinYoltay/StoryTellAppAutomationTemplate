package steps;

import helper.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Landingpage_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 20:23
 */
public class LandingPage_Steps {

    final Landingpage_Page landingpage_page = new Landingpage_Page(Driver.current());

    /**
     * open Storytel app
     */
    @Given("I open Storytel app")
    public void i_open_storytel_app() {
        Assert.assertTrue(landingpage_page.checkLoginBtn());
    }

    /**
     * Swipe stories to left and right and verify swiping works correctly
     */
    @When("I Swipe stories to left and right and verify swiping works correctly")
    public void i_swipe_stories_to_left_and_right_and_verify_swiping_works_correctly() {
        landingpage_page.setItemList();
    }

    /**
     * Click on Try it out button
     */
    @Then("Click on Try it out button")
    public void click_on_try_it_out_button() {
        landingpage_page.tryItOutBtn();
        Assert.assertTrue(landingpage_page.checkCountryPageTitle());
    }

    /**
     * Scroll down to find “Iceland” selection
     */
    @Then("I scroll down to find “Iceland” selection")
    public void i_scroll_down_to_find_iceland_selection() {
        landingpage_page.setDropDown();
    }

    /**
     * Select “Iceland” and click “Done
     */
    @Then("I select “Iceland” and click “Done”")
    public void i_select_iceland_and_click_done() {
        landingpage_page.clickDoneBtn();
        Assert.assertTrue(landingpage_page.checkCountyName());
    }

    /**
     * Select only “English” from languages selections page and click “Done”
     */
    @Then("I select only “English” from languages selections page and click “Done”")
    public void i_select_only_english_from_languages_selections_page_and_click_done() {
        landingpage_page.setLanguageSelector();
        Assert.assertFalse(landingpage_page.checkCountyName());
        landingpage_page.clickDoneBtn();
    }


}
