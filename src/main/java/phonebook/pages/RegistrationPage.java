package phonebook.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Class RegistrationPage contains all locators and methods page.
 */
public class RegistrationPage extends Page {
    // locators
    protected static By emailFieldRP = By.xpath("//*[@id='registration-form']/div[1]/div[1]/div/input");
    protected static By passwordFieldRP = By.xpath("//*[@id='registration-form']/div[2]/div[1]/div/input");
    protected static By confirmPasswordFieldRP = By.xpath("//*[@id='registration-form']/div[3]/div[1]/div/input");
    protected static By signUpBtnRP = By.xpath("//*[@id='registration-form']/div[4]/div[1]/button");
    protected static By AlreadyHaveAnAccountRP = By.xpath("/html/body/app-root/app-registration/div/div[1]/div/a");
    protected static By registrationPageTextRP = By.xpath("/html/body/app-root/app-registration/div/div[1]/div/h3");
    protected static By phoneBookTextRP = By.xpath("/html/body/app-root/app-registration/div/div[1]/div/h2");
    protected static By confirmPasswordIsRequiredErrorRP = By.xpath("//*[@id='confirm-password-error-required']");
    protected static By passwordsDoesNotMatchErrorRP = By.xpath("//*[@id='confirm-password-error-matcher']");
    protected static By emailMustBeAValidEmailError = By.xpath("//*[@id='registration-form']/div[1]/div[2]");

    // methods
    public ContactsPage clickOnSignUpBtn() {
        $(signUpBtnRP).click();
        return page(ContactsPage.class);
    }

    public void iSeeNoErrorMsg() {
        $(noErrorMsg).shouldHave(Condition.exist);
    }

    public void fillInRegistrationDataFields(String password, String confirmPassword) {
        $(emailFieldRP).setValue(faker.internet().emailAddress());
        $(passwordFieldRP).setValue(password);
        $(confirmPasswordFieldRP).setValue(confirmPassword);
    }
}
