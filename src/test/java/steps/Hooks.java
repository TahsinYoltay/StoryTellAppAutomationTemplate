package steps;

import helper.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Configuration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 20:07
 */
public class Hooks {

    @Before
    public void setUp() throws Exception {
        System.out.println("Driver capabilities added to driver");
        System.out.println("BEFORE HOOK");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("automationName", Configuration.get("automationName"));
        cap.setCapability("platformName", Configuration.get("platformName"));
        cap.setCapability("deviceName", Configuration.get("deviceName"));
        cap.setCapability("udid", Configuration.get("udid"));
        cap.setCapability("platformVersion", Configuration.get("platformVersion"));
//        cap.setCapability("udid", "R3CNA0E7FRF");
//        cap.setCapability("deviceName", "SM-G988B");
//        cap.setCapability("platformVersion", "11");
        cap.setCapability("app", Configuration.get("app"));
        cap.setCapability("appPackage", Configuration.get("appPackage"));
        cap.setCapability("autoLaunch", true);
        cap.setCapability("fullReset", false);
        WebDriver driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//        WebDriver driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.add(driver);

    }


    /** Physical Device Samsung S20 Ultra
     * {
     *   "platformName": "Android",
     *   "deviceName": "SM-G988B",
     *   "platformVersion": "11",
     *   "app": "/Users/eywa/Developer/Betbull/Storytel.apk",
     *   "udid": "R3CNA0E7FRF",
     *   "appPackage": "grit.storytel.app",
     *   "autoLaunch": true
     *
     *       cap.setCapability("udid", "R3CNA0E7FRF");
     *       cap.setCapability("deviceName", "SM-G988B")
     *       cap.setCapability("platformVersion", "11");
     *
     * }
     */

}
