package steps;

import helper.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Landingpage_Page;

import static util.Util.*;

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

    @Then("I scroll down to find “Feelgood” text from Book tips page")
    public void i_scroll_down_to_find_feelgood_text_from_book_tips_page() {
        landingpage_page.setDropDownToFeelGood();
//        landingpage_page.setDropDownToFeelGood();

    }

    @Then("I Swipe left on “Feelgood” section books and click on the 7th item from the list")
    public void i_swipe_left_on_feelgood_section_books_and_click_on_the_7th_item_from_the_list() {
        landingpage_page.getLocations();
//        landingpage_page.getFeelGoodScroll();

    }

    @Then("I Verify correct book is clicked")
    public void i_verify_correct_book_is_clicked() {
        System.out.println("The book name will be verified");

    }

    @Then("I Click like button")
    public void i_click_like_button() {
        landingpage_page.clickLikeBtn();
    }

    @Then("I Fill a valid email and password and click “Continue” button")
    public void i_fill_a_valid_email_and_password_and_click_continue_button() {
        landingpage_page.setEmailField(getSaltString());
        landingpage_page.setPasswordField(getPassword());
        landingpage_page.setContinueBtn();

    }

    @Then("I Click I Accept button Ég samþykki")
    public void i_click_i_accept_button_ég_samþykki() {
        landingpage_page.setPositiveBtn();
    }

    @Then("I Click “No thanks” to Marketing Consent popup")
    public void i_click_no_thanks_to_marketing_consent_popup() {
        landingpage_page.setPopupNegativeBtn();
        landingpage_page.waitUntilElementisVisible();

    }

    @Then("I Click Back button to close “Welcome to Storytel!” page")
    public void i_click_back_button_to_close_welcome_to_storytel_page() {
        landingpage_page.goBack();

    }

    @Then("I Click Like button and verify book is saved to bookshelf")
    public void i_click_like_button_and_verify_book_is_saved_to_bookshelf() {
        landingpage_page.clickLikeBtn();
    }

    @Then("I Click ← to go back to Book tips")
    public void i_click_to_go_back_to_book_tips() {
        landingpage_page.goBack();

    }

    @Then("I Open Side Menu")
    public void i_open_side_menu() {
        landingpage_page.setSideBarBtn();

    }

    @Then("I Click Search button")
    public void i_click_search_button() {
        landingpage_page.setSideSearchBtn();

    }

    @Then("I Swipe left to “Series” section")
    public void i_swipe_left_to_series_section() {
        landingpage_page.setSearchBar();
        landingpage_page.setBarScroll();

    }

    @Then("I Search for “Harry”")
    public void i_search_for_harry() {
        landingpage_page.setAutomcompleatebar("Harry");

    }

    @Then("I Swipe up on search result to find “Advantures of Harry Stevenson” and click on it")
    public void i_swipe_up_on_search_result_to_find_advantures_of_harry_stevenson_and_click_on_it() {
        landingpage_page.goBack();
        landingpage_page.clickSearchResult();

    }

    @Then("I Verify that page is the correct page")
    public void i_verify_that_page_is_the_correct_page() {

    }

    @Then("I Click Filter")
    public void i_click_filter() {

    }

    @Then("I Remove Ebook from Filter list and click “Done”")
    public void i_remove_ebook_from_filter_list_and_click_done() {

    }

    @Then("I Verify “Oops! It seems you've filtered a bit too much.” text on the screen.")
    public void i_verify_oops_it_seems_you_ve_filtered_a_bit_too_much_text_on_the_screen() {

    }


}
