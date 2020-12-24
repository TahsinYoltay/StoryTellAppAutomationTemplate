package util;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 22:51
 */
public class CommonActions {

    final WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public void ScrollDown(String scrollableListString, String elementClassName, String text) {

        try {

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + scrollableListString + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + text + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }
}
