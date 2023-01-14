package phonebook.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Class ForgotPasswordPage contains all locators and methods page.
 */
public class ForgotPasswordPage extends Page {
    // locators
    protected static By alreadyHaveAnAccountFPP = By.xpath("/html/body/app-root/app-forgot-password/div/div[1]/div/a[1]");
    protected static By RegisterNewAccountFPP = By.xpath("/html/body/app-root/app-forgot-password/div/div[1]/div/a[2]");
    protected static By emailFieldFPP = By.xpath("//*[@id='defaultRegisterFormEmail']");
    protected static By sendBtnFPP = By.xpath("//*[@id='forgot-pass-form']/div[2]/div[1]/button");
    protected static By phoneBookTextFPP = By.xpath("/html/body/app-root/app-forgot-password/div/div[1]/div/h2");
    protected static By passwordRecoveryTextFPP = By.xpath("/html/body/app-root/app-forgot-password/div/div[1]/div/h3");
    protected static By thisUserDoesNotExist = By.xpath("//*[@id='forgot-pass-form']/div[2]/div[2]");
    protected static By emailMustBeAValid = By.xpath("//*[@id='forgot-pass-form']/div[1]/div[2]/div");
    protected static By passwordRecoveryInstructionsMsg = By.xpath("//*[@id='success-message']/h6");

    // methods
    public void iSeePasswordRecoveryText() {
        $(passwordRecoveryTextFPP).shouldHave(Condition.exist);
    }

    public void clickOnSendBtnFPP() {
        $(sendBtnFPP).click();
    }

    public void fillEmailData(String email) {
        $(emailFieldFPP).setValue(email);
    }

    public String iSeeErrorMsg1(String msg) {
        $(emailMustBeAValid).shouldHave(text(msg));
        return msg;
    }

    public String iSeeErrorMsg2(String msg) {
        $(thisUserDoesNotExist).shouldHave(text(msg));
        return msg;
    }

    public String iSeeEmailMsg(String msg) {
        $(passwordRecoveryInstructionsMsg).shouldHave(text(msg));
        return msg;
    }

    public LoginPage alreadyHaveAnAccountClick(){
        $(alreadyHaveAnAccountFPP).click();
        return page(LoginPage.class);
    }
}
