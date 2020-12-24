package pages;

import helper.Driver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

import static util.Util.goBackBtn;
import static util.Util.horizontalSwipeWXpath;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 22:00
 */
public class Explore_Page extends BasePage {
    @AndroidFindBy(id = "grit.storytel.app:id/floatingSearchEditText")
    public AndroidElement searchBar;
    @AndroidFindBy(id = "grit.storytel.app:id/tabLayout")
    public AndroidElement tabBarScroll;
    @AndroidFindBy(id = "grit.storytel.app:id/autoCompleteTextView")
    public AndroidElement automcompleatebar;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceIdMatches(\"grit.storytel.app:id/recyclerView\").scrollable(true)).scrollIntoView(new UiSelector().text(\"Adventures of Harry Stevenson\"))")
    public AndroidElement searchResultScroll;
    @AndroidFindBy(id = "grit.storytel.app:id/headerTitleTextView")
    public AndroidElement titleText;
    @AndroidFindBy(id = "grit.storytel.app:id/buttonFilter")
    public AndroidElement filterBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.CheckBox[1]")
    public AndroidElement ebookCheckBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/textViewNoResult")
    public AndroidElement filterErrorMessage;
    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public AndroidElement doneBtn;

    public Explore_Page(WebDriver driver) {
        super(driver);
    }

    public void setSearchBar() {
        searchBar.click();
    }

    public void setBarScroll() {
        String xpath = "//android.widget.LinearLayout[@content-desc=\"Series\"]/android.widget.TextView";
        horizontalSwipeWXpath(tabBarScroll, Driver.current(), xpath);
    }

    public void setAutomcompleatebar(String input) {
        automcompleatebar.click();
        automcompleatebar.sendKeys(input);
    }

    public void goBack() {
        goBackBtn();
    }

    public void clickSearchResult() {
        searchResultScroll.click();
    }

    public String getTitle() {
        return titleText.getText();
    }

    public void clickFilterBtn() {
        filterBtn.click();
    }

    public void setEbookCheckBtn() {
        ebookCheckBtn.click();
    }

    public String getFilterErrorMessage() {
        return filterErrorMessage.getText();
    }

    public void clickDoneBtn() {
        doneBtn.click();
    }

}
