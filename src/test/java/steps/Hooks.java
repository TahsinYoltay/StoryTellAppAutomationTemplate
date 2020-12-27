package steps;

import helper.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Configuration;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static util.AppiumServer.Start;
import static util.AppiumServer.Stop;


public class Hooks {


    /**
     * Physical Device Samsung S20 Ultra
     * {
     * "platformName": "Android",
     * "deviceName": "SM-G988B",
     * "platformVersion": "11",
     * "app": "/Users/eywa/Developer/Betbull/Storytel.apk",
     * "udid": "R3CNA0E7FRF",
     * "appPackage": "grit.storytel.app",
     * "autoLaunch": true
     * <p>
     * cap.setCapability("udid", "R3CNA0E7FRF");
     * cap.setCapability("deviceName", "SM-G988B")
     * cap.setCapability("platformVersion", "11");
     * <p>
     * }
     */

    @Before
    public void setUp() throws Exception {

        Start();
        System.out.println(Configuration.get("app"));
        System.out.println("Driver capabilities added to driver");
        File apkPath = new File(Configuration.get("app"));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
//        cap.setCapability("automationName", Configuration.get("automationName"));
        cap.setCapability("platformName", Configuration.get("platformName"));
        cap.setCapability("deviceName", Configuration.get("deviceName"));
        cap.setCapability("udid", Configuration.get("udid"));
        cap.setCapability("platformVersion", Configuration.get("platformVersion"));
        cap.setCapability("app", apkPath.getAbsolutePath());
        cap.setCapability("appPackage", Configuration.get("appPackage"));
        cap.setCapability("autoLaunch", true);
        cap.setCapability("fullReset", false);
        WebDriver driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.add(driver);

    }

    @After
    public void tearDown() {
        Stop();
        Driver.current().quit();
    }


}
