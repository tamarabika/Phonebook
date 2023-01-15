package phonebook.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static phonebook.pages.Constants.USER_EMAIL_LP;
import static phonebook.pages.Constants.USER_PASSWORD_LP;

/**
 * Class Login page  contains all locators and methods page.
 */
public class LoginPage extends Page {
    // locators
    protected static By emailFieldLP = By.xpath("//*[@id='defaultRegisterFormEmail']");
    protected static By passwordFieldLP = By.xpath("//*[@id='login-form']/div[2]/div[1]/div/input");
    protected static By loginBtnLP = By.xpath("//*[@id='login-form']/div[3]/div[1]/button");
    protected static By phoneBookTextLP = By.xpath("/html/body/app-root/app-login/div/div[1]/div/div/h2");
    protected static By loginTextLP = By.xpath("/html/body/app-root/app-login/div/div[1]/div/div/h3");
    protected static By registerNewAccountLP = By.xpath("/html/body/app-root/app-login/div/div[1]/div/div/a[1]");
    protected static By forgotPasswordLP = By.xpath("/html/body/app-root/app-login/div/div[1]/div/div/a[2]");
    protected static By pleaseCheckYourActivationOrLoginPasswordCombinationErrorLP = By.xpath("//*[@id='error-message']");
    protected static By emailMustBeAValidEmailAddressError = By.xpath("//*[@id='email-error-invalid']");

    // methods
    public ContactsPage clickOnLoginBtnLP() {
        $(loginBtnLP).click();
        return page(ContactsPage.class);
    }

    public void fillInDataFields(String email, String password) {
        $(emailFieldLP).setValue(email);
        $(passwordFieldLP).setValue(password);
    }

    public RegistrationPage clickOnRegisterNewAccount() {
        $(registerNewAccountLP).click();
        return page(RegistrationPage.class);
    }

    public void fillInLoginInvalidDataFields() {
        $(emailFieldLP).setValue(faker.internet().emailAddress());
        $(passwordFieldLP).setValue(faker.internet().password());
    }

    public void iSeePleaseCheckYourActivationOrLoginPasswordCombinationMsg() {
        $(pleaseCheckYourActivationOrLoginPasswordCombinationErrorLP).shouldHave(Condition.exist);
    }

    public By iSeeEmailMustBeAValidEmailAddressMsg(String msg) {
        $(emailMustBeAValidEmailAddressError).shouldHave(text(msg));
        return (emailMustBeAValidEmailAddressError);
    }

    public void clickOnEmailFieldLP() {
        $(emailFieldLP).click();
    }

    public void clickOnPasswordFieldLP() {
        $(passwordFieldLP).click();
    }

    public void emailIsRequired() {
        $(emailIsRequiredError).shouldHave(Condition.exist);
    }

    public void passwordIsRequired() {
        $(passwordIsRequiredError).shouldHave(Condition.exist);
    }

    public String passwordMustBe(String msg) {
        $(passwordMustBeError).shouldHave(text(msg));
        return (msg);
    }

    public ForgotPasswordPage clickOnForgotPassword() {
        $(forgotPasswordLP).click();
        return page(ForgotPasswordPage.class);
    }

    public void iSeeLoginPage() {
        $(loginTextLP).shouldHave(Condition.exist);
    }

    public void enterUseEmail() {
        $(emailFieldLP).setValue(USER_EMAIL_LP);

    }

    public void enterUserPassword() {
        $(passwordFieldLP).setValue(USER_PASSWORD_LP);
    }
}
