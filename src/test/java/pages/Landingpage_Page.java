package pages;

import helper.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static util.Util.*;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 19/12/2020
 * Time: 20:56
 */
public class Landingpage_Page extends BasePage {

    @AndroidFindBy(id = "grit.storytel.app:id/create_account_preview")
    public AndroidElement tryItOutBtn;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Iceland\").instance(0))")
    public AndroidElement dropDown;
    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public AndroidElement doneBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Icelandic\")")
    public AndroidElement languageSelector;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Feelgood\").instance(0))")
    public AndroidElement dropDownToFeelGood;
    public By scroll = By.id("grit.storytel.app:id/booktipHorizontalTitle");
    /**
     * Feel good section left swipe
     * "new UiScrollable(new UiSelector().scrollable(true)."
     * + "resourceId(\"<id of scrollable control>\"))"
     * + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"<text to search for>\"))"
     */

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(2)."
            + "resourceId(\"grit.storytel.app:id/booktipHorizontalRecyclerView\"))"
            + ".setAsHorizontalList().scrollIntoView(new UiSelector().descriptionContains(\"Asking\"))")
    public AndroidElement getFeelGoodScroll;
    /**
     * Test feel good scroll
     * [el.getLocation().getX(), el.getLocation().getY()] // first [x,y]
     * [el.getLocation().getX() +el.getSize().getWidth(),
     * el.getLocation().getY()+
     * el.getSize().getHeight()] // second [x,y]
     */
    @AndroidFindBy(accessibility = "Feelgood")
    public WebElement bounds;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView")
    public AndroidElement bounderies;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"No Good Asking\"]")
    public WebElement seventhElement;
    /**
     * Landing Page Swipe Left  & Righ
     */
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"grit.storytel.app:id/carousel_title\")).setAsHorizontalList().scrollIntoView("
            + "new UiSelector().text(\"Stories that want to be heard\"))")
    public AndroidElement itemList;
    @AndroidFindBy(id = "grit.storytel.app:id/btnBookshelfToggle")
    public AndroidElement likeBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_email")
    public AndroidElement emailField;
    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_password")
    public AndroidElement passwodField;
    @AndroidFindBy(id = "grit.storytel.app:id/button_sign_in")
    public AndroidElement continueBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/button_positive")
    public AndroidElement positiveBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/button_positive")
    public WebElement positiveBtnV2;
    @AndroidFindBy(id = "grit.storytel.app:id/button_negative")
    public AndroidElement popupNegativeBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")
    public AndroidElement sideBarBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement sideSearchBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/floatingSearchEditText")
    public AndroidElement searchBar;
    @AndroidFindBy(id = "grit.storytel.app:id/tabLayout")
    public AndroidElement tabBarScroll;
    @AndroidFindBy(id = "grit.storytel.app:id/autoCompleteTextView")
    public AndroidElement automcompleatebar;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceIdMatches(\"grit.storytel.app:id/recyclerView\").scrollable(true)).scrollIntoView(new UiSelector().text(\"Adventures of Harry Stevenson\"))")
    public AndroidElement searchResultScroll;
    public By searchResult = By.id("grit.storytel.app:id/tvTitle");

    public Landingpage_Page(WebDriver driver) {
        super(driver);
    }

    public void tryItOutBtn() {
        tryItOutBtn.click();
    }

    public void setDropDown() {
        dropDown.click();
    }

    public void clickDoneBtn() {
        doneBtn.click();
    }

    public void setLanguageSelector() {
        languageSelector.click();
    }

    public void setDropDownToFeelGood() {
        scrollNWClick(scroll, "Feelgood");
    }

    public void getFeelGoodScroll() {
        getFeelGoodScroll.click();
    }

    public void getLocations() {
        String element = "//android.widget.ImageView[@content-desc=\"The Helpline\"]";
        horizontalSwipe(bounderies, Driver.current(), element);
    }

    public void setItemList() throws InterruptedException {
        itemList.click();
    }

    public void clickLikeBtn() {
        likeBtn.click();
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setPasswordField(String password) {
        passwodField.sendKeys(password);
    }

    public void setContinueBtn() {
        continueBtn.click();
    }

    public void setPositiveBtn() {
        positiveBtnV2.click();

    }

    public void setPopupNegativeBtn() {
        popupNegativeBtn.click();
    }

    public void goBack() {
        goBackBtn();
    }

    public void waitUntilElementisVisible() {
        String welcomeMessage = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]";
        exists(welcomeMessage);
    }

    public void setSideBarBtn() {
        sideBarBtn.click();
    }

    public void setSideSearchBtn() {
        sideSearchBtn.click();
    }

    public void setSearchBar() {
        searchBar.click();
    }

    public void setBarScroll() {
        String xpath = "//android.widget.LinearLayout[@content-desc=\"Series\"]/android.widget.TextView";
        horizontalSwipe(tabBarScroll, Driver.current(), xpath);
    }

    public void setAutomcompleatebar(String input) {
        automcompleatebar.click();
        automcompleatebar.sendKeys(input);

    }

    public void clickSearchResult() {
        searchResultScroll.click();

    }
}
