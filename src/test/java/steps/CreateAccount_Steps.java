package steps;

import helper.Driver;
import io.cucumber.java.en.Then;
import pages.CreateAccout_Page;

import static util.Util.getPassword;
import static util.Util.getSaltString;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:34
 */
public class CreateAccount_Steps {

    final CreateAccout_Page createAccout_page = new CreateAccout_Page(Driver.current());

    /**
     * Fill a valid email and password and click “Continue” button
     */
    @Then("I Fill a valid email and password and click “Continue” button")
    public void i_fill_a_valid_email_and_password_and_click_continue_button() {
        createAccout_page.setEmailField(getSaltString());
        createAccout_page.setPasswordField(getPassword());
        createAccout_page.setContinueBtn();
    }

    /**
     * Click I Accept button Ég samþykki
     */
    @Then("I Click I Accept button Ég samþykki")
    public void i_click_i_accept_button_ég_samþykki() {
        createAccout_page.setPositiveBtn();
    }

    /**
     * Click “No thanks” to Marketing Consent popup
     */
    @Then("I Click “No thanks” to Marketing Consent popup")
    public void i_click_no_thanks_to_marketing_consent_popup() {

        createAccout_page.setPopupNegativeBtn();
        createAccout_page.waitUntilElementisVisible();

    }

}
