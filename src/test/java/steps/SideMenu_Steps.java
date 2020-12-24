package steps;

import helper.Driver;
import io.cucumber.java.en.Then;
import pages.SideMenu_Page;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:55
 */
public class SideMenu_Steps {

    final SideMenu_Page sideMenu_page = new SideMenu_Page(Driver.current());

    /**
     * Open Side Menu
     */
    @Then("I Open Side Menu")
    public void i_open_side_menu() {
        sideMenu_page.setSideBarBtn();

    }

    /**
     * Click Search button
     */
    @Then("I Click Search button")
    public void i_click_search_button() {
        sideMenu_page.setSideSearchBtn();

    }


}
