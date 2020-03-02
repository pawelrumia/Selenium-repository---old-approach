package framework.assertContactPage;

import org.assertj.core.api.SoftAssertions;
import pages.ContactPage;

public class AssertContactPage implements Validate {
    private final SoftAssertions softAssertions;

    public AssertContactPage() {
        this.softAssertions = new SoftAssertions();
    }

    public AssertContactPage hasCorrectPageTitle(ContactPage contactPage) {
        softAssertions.assertThat(contactPage.getPageTitle())
                .isEqualTo("Kontakt - Bluemedia");
        return this;
    }

    public AssertContactPage hasSubmitButtonDisplayed(ContactPage contactPage) {
        softAssertions.assertThat(contactPage.isSubmitButtonDisplayed()).isTrue();
        return this;
    }

    @Override
    public void assertAll() {
        softAssertions.assertAll();
    }
}
