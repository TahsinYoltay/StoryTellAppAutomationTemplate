package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

public class Landingpage_Page extends BasePage {

    @AndroidFindBy(id = "grit.storytel.app:id/create_account_preview")
    public AndroidElement tryItOutBtn;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Iceland\").instance(0))")
    public AndroidElement dropDown;
    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public AndroidElement doneBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Icelandic\")")
    public AndroidElement languageSelector;
    @AndroidFindBy(id = "grit.storytel.app:id/login")
    public AndroidElement loginBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Icelandic\")")
    public AndroidElement countyName;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Choosing your country of residence will help us find the right content for you\")")
    public AndroidElement countryPageTitle;


    /**
     * Landing Page Swipe Left  & Righ
     */
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"grit.storytel.app:id/carousel_title\")).setAsHorizontalList().scrollIntoView("
            + "new UiSelector().text(\"Stories that want to be heard\"))")
    public AndroidElement itemList;


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

    public void setItemList() {
        itemList.click();
    }

    public boolean checkLoginBtn() {
        boolean isDisplayed = loginBtn.isDisplayed();
        return isDisplayed;
    }

    public Boolean checkCountyName() {
        boolean isChecked;
        String value = countyName.getAttribute("checked");
        System.out.println(value);
        if (value.equalsIgnoreCase("true")) {
            isChecked = true;
        } else {
            isChecked = false;
        }
        return isChecked;
    }

    public boolean checkCountryPageTitle() {
        boolean isDisplayed = countryPageTitle.isDisplayed();
        return isDisplayed;
    }
}
