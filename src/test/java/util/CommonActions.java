package util;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 22:51
 */
public class CommonActions {

    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public void ScrollDown(String scrollableListString, String elementClassName, String text) {

        try {
            String scrollableList = scrollableListString;
            String elementClass = elementClassName;
            String anyText = text;

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClass + "\"), \"" + anyText + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }
}
