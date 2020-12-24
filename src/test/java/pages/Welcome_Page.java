package pages;

import org.openqa.selenium.WebDriver;

import static util.Util.goBackBtn;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:45
 */
public class Welcome_Page extends BasePage {

    public Welcome_Page(WebDriver driver) {
        super(driver);
    }

    public void goBack() {
        goBackBtn();
    }

}
