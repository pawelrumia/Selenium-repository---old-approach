package pages;

import framework.driver.BaseDriver;
import framework.methods.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
    private WebDriver driver = BaseDriver.getDriver();

    private Element businessClientRadioButton;
    private Element nameAndSurnameTxtField;
    private Element emailTxtField;
    private Element companyNameTxtField;
    private Element phoneTxtField;
    private Element topicDropdownList;
    private Element detailsTxtField;
    private Element emailConfirmationRadioButton;
    private Element dataProcessingAgreementCheckbox;
    private Element submitButton;

    public ContactPage() {
        businessClientRadioButton = new Element(By.xpath("//div[@class = 'grid-24'][2]"));
        nameAndSurnameTxtField = new Element(By.id("name"));
        emailTxtField = new Element(By.id("email_c"));
        companyNameTxtField = new Element(By.id("company_name"));
        phoneTxtField = new Element(By.id("phone"));
        topicDropdownList = new Element(By.id("select2-subject-container"));
        detailsTxtField = new Element(By.id("body"));
        emailConfirmationRadioButton = new Element(By.cssSelector(".form__radio input[value = 'email']"));
        dataProcessingAgreementCheckbox = new Element(By.id("agreement_1"));
        submitButton = new Element(By.cssSelector("button[type = 'submit']"));
    }

    public ContactPage openHomePage() {
        driver.get("https://bluemedia.pl/kontakt");
        return this;
    }

    public ContactPage populateName(String name) {
        nameAndSurnameTxtField.enterText(name);
        return this;
    }

    public ContactPage selectBusinessClient() {
        businessClientRadioButton.click();
        return this;
    }

    public ContactPage populateEmail(String email) {
        emailTxtField.enterText(email);
        return this;
    }

    public ContactPage populateCompanyName(String companyName) {
        companyNameTxtField.enterText(companyName);
        return this;
    }

    public ContactPage populatePhoneNumber(String phoneNumber) {
        phoneTxtField.enterText(phoneNumber);
        return this;
    }

    public ContactPage selectValueFromList(String listId, String value) {
        topicDropdownList.selectFromListByVisibleText(By.id(listId), value);
        return this;
    }

    public ContactPage populateBody(String freeText) {
        detailsTxtField.enterText(freeText);
        return this;
    }

    public ContactPage clickOnEmailResponseButton() {
        emailConfirmationRadioButton.click();
        return this;
    }

    public void checkDataProcessingAgreementCheckbox() {
        dataProcessingAgreementCheckbox.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }
}
