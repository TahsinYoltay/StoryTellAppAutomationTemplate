package steps;

import helper.Driver;
import io.cucumber.java.en.Then;
import pages.Welcome_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:46
 */
public class WelcomePage_Steps {

    Welcome_Page welcome_page = new Welcome_Page(Driver.current());

    @Then("I Click Back button to close “Welcome to Storytel!” page")
    public void i_click_back_button_to_close_welcome_to_storytel_page() {
        welcome_page.goBack();

    }

}
