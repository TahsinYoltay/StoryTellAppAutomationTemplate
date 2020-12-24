package steps;

import helper.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Landingpage_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 20:23
 */
public class LandingPage_Steps {

    Landingpage_Page landingpage_page = new Landingpage_Page(Driver.current());


    @Given("I open Storytel app")
    public void i_open_storytel_app() {

        System.out.println("Application launch check");

    }

    @When("I Swipe stories to left and right and verify swiping works correctly")
    public void i_swipe_stories_to_left_and_right_and_verify_swiping_works_correctly() throws InterruptedException {
//        landingpage_page.setItemList();
        landingpage_page.setItemList();
        System.out.println("Swipe functionality will be implemented");

    }

    @Then("Click on Try it out button")
    public void click_on_try_it_out_button() {
        landingpage_page.tryItOutBtn();
        System.out.println("Try it button clicked");

    }

    @Then("I scroll down to find “Iceland” selection")
    public void i_scroll_down_to_find_iceland_selection() {
        landingpage_page.setDropDown();

    }

    @Then("I select “Iceland” and click “Done”")
    public void i_select_iceland_and_click_done() {
        landingpage_page.clickDoneBtn();

    }

    @Then("I select only “English” from languages selections page and click “Done”")
    public void i_select_only_english_from_languages_selections_page_and_click_done() {
        landingpage_page.setLanguageSelector();
        landingpage_page.clickDoneBtn();
    }


}
