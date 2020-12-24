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


}
