package pages;

import helper.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static util.Util.*;


public class BookTip_Page extends BasePage {


    /**
     * Get Book Trip Page View id
     */
    public final By scroll = By.id("grit.storytel.app:id/booktipHorizontalTitle");

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView")
    public AndroidElement bounderies;
    @AndroidFindBy(id = "grit.storytel.app:id/btnBookshelfToggle")
    public AndroidElement likeBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved to your bookshelf\")")
    public AndroidElement snackBar;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView")
    public AndroidElement scrollView;

    public BookTip_Page(WebDriver driver) {
        super(driver);

    }

    public void setDropDownToFeelGood() {
        scrollNWClick(scroll, "Feelgood");
    }

    public void getLocations() {
        horizontalSwipes(7);
    }

    public void clickLikeBtn() {
        likeBtn.click();
    }


    public String getSnackBarText() {
        return snackBar.getText();
    }

    public void goBack() {
        goBackBtn();
    }


    public void horizontalSwipes(int index) {

        WebElement Panel = bounderies;
        Dimension dimension = Panel.getSize();

        int Anchor = calculateAnchor(bounderies);
        double ScreenWidthStart = dimension.getWidth() * 0.8;
        int scrollStart = (int) ScreenWidthStart;

        double ScreenWidthEnd = dimension.getWidth() * 0.2;
        int scrollEnd = (int) ScreenWidthEnd;

        WebElement viewGroup = scrollView;

        List<String> elementList = new ArrayList<>();


        boolean flag = false;
        while (true) {
            if (flag) {
                break;
            } else {
                List<WebElement> allTextViews = viewGroup.findElements(By.className("android.view.ViewGroup"));

                for (WebElement allTextView : allTextViews) {
                    if (!elementList.contains(allTextView.findElements(By.className("android.widget.ImageView")).get(0).getAttribute("content-desc")) && elementList.size() < index && !flag) {
                        elementList.add(allTextView.findElements(By.id("grit.storytel.app:id/bookCoverImage")).get(0).getAttribute("content-desc"));

                    } else if (elementList.size() == index) {
                        Driver.current().findElement(new MobileBy.ByAccessibilityId(elementList.get(index - 1))).click();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    new TouchAction((PerformsTouchActions) Driver.current())
                            .press(PointOption.point(scrollStart, Anchor))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                            .moveTo(PointOption.point(scrollEnd, Anchor))
                            .release().perform();
                } else {
                    break;
                }
            }
        }
    }

}
