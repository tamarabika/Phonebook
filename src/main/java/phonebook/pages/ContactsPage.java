package phonebook.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class ContactsPage contains all locators and methods page.
 */
public class ContactsPage extends Page {
    // locators
    protected static By contactsCP = By.xpath("/html/body/app-root/app-home-page/app-header/nav");
    protected static By addNewContactCP = By.xpath("/html/body/app-root/app-home-page/app-header/nav/div/ul/li[2]/a");
    protected static By textCP = By.xpath("//*[@id='input-search-contact']");
    protected static By languageCP = By.xpath("//*[@id='langSelect']");
    protected static By englishCP = By.xpath("//*[@id='langSelect']/option[1]");
    protected static By germanCP = By.xpath("//*[@id='langSelect']/option[3]");
    protected static By ukraineCP = By.xpath("//*[@id='langSelect']/option[4]");
    protected static By russianCP = By.xpath("//*[@id='langSelect']/option[2]");
    protected static By textAddNewContactCP = By.xpath("/html/body/app-root/app-home-page/app-header/nav/div/ul/li[2]/a");
    protected static By firstName = By.xpath("//*[@id='form-name']");
    protected static By lastName = By.xpath("//*[@id='form-lastName']");
    protected static By contactDescription = By.xpath("//*[@id='form-about']");
    protected static By saveBtn = By.xpath("//*[@id='add-contact-form']/div[4]/button[2]");
    protected static By canselBtn = By.xpath("//*[@id='add-contact-form']/div[4]/button[1]");
    protected static By editBtn = By.xpath("//*[@id='btn-edit-contact']");
    protected static By addPhoneNumberBtn = By.xpath("//*[@id='ngb-nav-11-panel']/app-phone/div[1]");
    protected static By addEmailBtn = By.xpath("//*[@id='ngb-nav-12-panel']/app-email/div[1]");
    protected static By addAddressBtn = By.xpath("///*[@id='ngb-nav-13-panel']/app-address/div[1]");
    protected static By infoTab = By.xpath("//*[@id='ngb-nav-10']");
    protected static By phonesTab = By.xpath("///*[@id='ngb-nav-11']");
    protected static By emailsTab = By.xpath("//*[@id='ngb-nav-12']");
    protected static By addressesTab = By.xpath("//*[@id='ngb-nav-13']");
    protected static By firstNameField = By.xpath("//*[@id='edit-contact-form']/div[1]/div[2]/input");
    protected static By lastNameField = By.xpath("//*[@id='edit-contact-form']/div[2]/div[2]/input");
    protected static By contactDescriptionField= By.xpath("//*[@id='edit-contact-form']/div[3]/div[2]/textarea");
    protected static By saveEditBtn = By.xpath(" //*[@id='edit-contact-form']/div[4]/div[2]/div/button[2]");

    // methods
    public void iSeeTextCP() {
        $(textCP).shouldHave(Condition.exist);
    }

    public void imChoosingLanguageCP() {
        $(languageCP).shouldHave(Condition.exist);
        $(languageCP).click();
        $(englishCP).shouldHave(Condition.visible);
        $(englishCP).click();
    }

    public void iClickAddNewContactCP() {
        $(addNewContactCP).click();
    }

    public void iSeePopUpCP() {
        $(textAddNewContactCP).shouldHave(Condition.visible);
    }

    public By checkLanguage(String text) {
        $(languageCP).click();
        $(englishCP).click();
        if (englishCP.equals("English")) {
            $(textAddNewContactCP).shouldHave(text(text));
            return (textAddNewContactCP);
        }

        $(languageCP).click();
        $(germanCP).click();
        if (englishCP.equals("German")) {
            $(textAddNewContactCP).shouldHave(text(text));
            return (textAddNewContactCP);
        }

        $(languageCP).click();
        $(ukraineCP).click();
        if (englishCP.equals("Ukraine")) {
            $(textAddNewContactCP).shouldHave(text(text));
            return (textAddNewContactCP);
        }

        $(languageCP).click();
        $(russianCP).click();
        if (englishCP.equals("Russian")) {
            $(textAddNewContactCP).shouldHave(text(text));
            return (textAddNewContactCP);
        }
        return null;
    }

    public void fillContactsData() {
        $(firstName).setValue(faker.name().firstName());
        $(lastName).setValue(faker.name().lastName());
        $(contactDescription).setValue(faker.internet().emailAddress());
    }

    public void saveBtnClick() {
        $(saveBtn).click();
    }

    public void iSeeEditBtn() {
        $(editBtn).shouldHave(Condition.exist);
    }

    public void editBtnClick() {
        $(editBtn).click();
    }

    public void contactDataChange(String fName) {
        $(firstNameField).setValue(fName);
    }

    public void saveEditBtnClick() {
        $(saveEditBtn).click();
    }

    public void contactChanged() {
        $(editBtn).shouldHave(Condition.exist);
    }
}



