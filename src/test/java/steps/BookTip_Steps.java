package steps;

import helper.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BookTip_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:04
 */
public class BookTip_Steps {

    /**
     * Book_
     */
    final BookTip_Page bookTip_page = new BookTip_Page(Driver.current());


    /**
     * Scroll down to find “Feelgood” text from Book tips page
     */
    @Then("I scroll down to find “Feelgood” text from Book tips page")
    public void i_scroll_down_to_find_feelgood_text_from_book_tips_page() {
        bookTip_page.setDropDownToFeelGood();
    }

    /**
     * I Swipe left on “Feelgood” section books and click on the *th item from the list
     */
    @Then("I Swipe left on “Feelgood” section books and click on the 7th item from the list")
    public void i_swipe_left_on_feelgood_section_books_and_click_on_the_7th_item_from_the_list() {
        bookTip_page.getLocations();
    }

    /**
     * Verify correct book is clicked
     */
    @Then("I Verify correct book is clicked")
    public void i_verify_correct_book_is_clicked() {
        System.out.println("The book name will be verified");

    }


    /**
     *
     */
    @Then("I Click like button")
    public void i_click_like_button() {
        bookTip_page.clickLikeBtn();
    }

    @Then("I Click Like button and verify book is saved to bookshelf")
    public void i_click_like_button_and_verify_book_is_saved_to_bookshelf() {
        bookTip_page.clickLikeBtn();
        Assert.assertEquals(bookTip_page.getSnackBarText(), "Saved to your bookshelf");

    }

    @Then("I Click ← to go back to Book tips")
    public void i_click_to_go_back_to_book_tips() {
        bookTip_page.goBack();

    }

}
