package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 20:44
 */
public abstract class BasePage {
    protected WebDriver driver;

    /**
     * Page Factory init
     *
     * @param driver Android driver
     */
    public BasePage(WebDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * @return Current Android Driver
     */
    public WebDriver getDriver() {
        return driver;
    }


}
