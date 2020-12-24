package helper;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 20:14
 */
public class Driver {

    private static final ConcurrentHashMap<String, WebDriver> driverThreadMap = new ConcurrentHashMap<>();

    public static String getThreadName() {
        return Thread.currentThread().getName() + "-" + Thread.currentThread().getId();
    }

    public static void add(WebDriver driver) {
        String threadName = getThreadName();
        driverThreadMap.put(threadName, driver);
    }

    public static WebDriver current() {
        String threadName = getThreadName();
        return driverThreadMap.get(threadName);
    }


}
