package phonebook.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

/**
 * Abstract class Page contains common locators, data and methods shared within the Wolt pages.
 */
public abstract class Page {
    // locators
    protected static By emailIsRequiredError = By.xpath("//*[@id='email-error-required']");
    protected static By passwordIsRequiredError = By.xpath("//*[@id='password-error-required']");
    protected static By passwordMustBeError = By.xpath("//*[@id='login-form']/div[2]/div[2]");
    protected static By noErrorMsg = By.xpath("//*[@id='error-message']");

    static Faker faker = new Faker();

    // methods
}
