package util;

import com.google.common.collect.ImmutableList;
import helper.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Point;
import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

public class Util {

    private static Dimension windowSize;
    private static final Duration SCROLL_DUR = Duration.ofMillis(1000);
    private static final double SCROLL_RATIO = 0.8;

    public static void scrollDown() {
        Dimension dimension = Driver.current().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.7);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);

        new TouchAction((PerformsTouchActions) Driver.current())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }


    /**
     * @param el     Web element (View&Screen) which will be calculated for bounds
     * @param driver Web driver
     */

    public static void horizontalSwipeWXpath(WebElement el, WebDriver driver, String xpath) {
        Dimension dimension = el.getSize();

        int Anchor = calculateAnchor(el);
        double ScreenWidthStart = dimension.getWidth() * 0.8;
        int scrollStart = (int) ScreenWidthStart;

        double ScreenWidthEnd = dimension.getWidth() * 0.2;
        int scrollEnd = (int) ScreenWidthEnd;


        boolean flag = false;
        while (true) {
            if (exists(xpath)) {
                flag = true;
                driver.findElement(By.xpath(xpath)).click();
                break;
            }
            if (flag)
                break;
            else
                new TouchAction((PerformsTouchActions) driver)
                        .press(PointOption.point(scrollStart, Anchor))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(scrollEnd, Anchor))
                        .release().perform();
        }
    }

    public static boolean exists(String element) {
        WebDriverWait wait = new WebDriverWait(Driver.current(), 1);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static void scrollNClick(By listItems, String Text) {
        boolean flag = false;

        while (true) {
            for (WebElement el : Driver.current().findElements(listItems)) {
                if (el.getAttribute("text").equalsIgnoreCase(Text)) {
                    el.click();
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            else
                scrollDown();
        }
    }


    public static void scrollNWClick(By listItems, String Text) {
        boolean flag = false;

        while (true) {
            for (WebElement el : Driver.current().findElements(listItems)) {
                if (el.getAttribute("text").equals(Text)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            else
                scrollDown();
        }
    }


    public static void scrollNClick(WebElement el) {
        int retry = 0;
        while (retry <= 5) {
            try {
                el.click();
                break;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                scrollDown();
                retry++;
            }
        }
    }

    public static void scrollIntoView(String Text) {
        String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector + ");";
        ((AndroidDriver<?>) Driver.current()).findElementByAndroidUIAutomator(command);

    }

    /**
     * //https://appium.io/docs/en/writing-running-appium/ios/ios-xctest-mobile-gestures/
     *
     * @param Text
     */

    public static void scrollTo(String Text) {

        if (Driver.current() instanceof AndroidDriver<?>) {
            scrollIntoView(Text);
        } else if (Driver.current() instanceof IOSDriver<?>) {
            final HashMap<String, String> scrollObject = new HashMap<>();
            scrollObject.put("predicateString", "value == '" + Text + "'");
            scrollObject.put("toVisible", "true");
            ((IOSDriver<?>) Driver.current()).executeScript("mobile: scroll", scrollObject);
        }
    }

    private static Dimension getWindowSize() {
        if (windowSize == null) {
            windowSize = Driver.current().manage().window().getSize();
        }
        return windowSize;
    }

    public static void scroll(ScrollDirection dir, double distance) {
        if (distance < 0 || distance > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = getWindowSize();
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
        int top = midPoint.y - (int) ((size.height * distance) * 0.5);
        int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
        int left = midPoint.x - (int) ((size.width * distance) * 0.5);
        int right = midPoint.x + (int) ((size.width * distance) * 0.5);
        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    protected static void swipe(Point start, Point end, Duration duration) {
        boolean isAndroid = Driver.current() instanceof AndroidDriver<?>;

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        if (isAndroid) {
            int ANDROID_SCROLL_DIVISOR = 3;
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver<?>) Driver.current()).perform(ImmutableList.of(swipe));
    }

    public static void click(By byEl) {
        new WebDriverWait(Driver.current(), 20).until(ExpectedConditions.presenceOfElementLocated(byEl)).click();
    }

    public static void sendKeys(By byEl, String text) {
        waitForEl(byEl);
        Driver.current().findElement(byEl).sendKeys(text);
    }

    public static void waitForEl(By byEl) {
        new WebDriverWait(Driver.current(), 20).until(ExpectedConditions.presenceOfElementLocated(byEl));
    }

    public static int calculateAnchor(WebElement element) {

        int centerY;

        int y1 = element.getLocation().getY();
        int y2 = element.getLocation().getY() + element.getSize().getHeight();
        centerY = y2 - ((y2 - y1) / 2);
        return centerY;

    }

    public static void SwipeScreen(WebElement el, WebDriver driver) throws InterruptedException {
        Dimension dimension = el.getSize();

        int Anchor = calculateAnchor(el);

        double ScreenWidthStart = dimension.getWidth() * 0.8;
        int scrollStart = (int) ScreenWidthStart;

        double ScreenWidthEnd = dimension.getWidth() * 0.2;
        int scrollEnd = (int) ScreenWidthEnd;
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(scrollStart, Anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(scrollEnd, Anchor))
                .release().perform();

        Thread.sleep(1000);
    }

    /**
     * Dummy e-mail Generator
     * usage : getSaltString()+"@gmail.com"
     */
    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";

    }

    /**
     * Random Password generator
     */

    public static String getPassword() {
        return new Random().ints(10, 33, 122).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void goBackBtn() {
        ((AndroidDriver) Driver.current()).pressKey(new KeyEvent(AndroidKey.BACK));

    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

}