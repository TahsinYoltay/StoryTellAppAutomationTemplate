package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static util.Util.exists;

/**
 * Created by IntelliJ IDEA.
 * User: TAHSIN YOLTAY
 * Date: 23/12/2020
 * Time: 21:33
 */
public class CreateAccout_Page extends BasePage {
    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_email")
    public AndroidElement emailField;
    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_password")
    public AndroidElement passwodField;
    @AndroidFindBy(id = "grit.storytel.app:id/button_sign_in")
    public AndroidElement continueBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/button_positive")
    public WebElement positiveBtn;
    @AndroidFindBy(id = "grit.storytel.app:id/button_negative")
    public AndroidElement popupNegativeBtn;

    public CreateAccout_Page(WebDriver driver) {
        super(driver);
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
        positiveBtn.click();

    }

    public void setPopupNegativeBtn() {
        popupNegativeBtn.click();
    }

    public void waitUntilElementisVisible() {
        String welcomeMessage = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]";
        exists(welcomeMessage);
    }

}
