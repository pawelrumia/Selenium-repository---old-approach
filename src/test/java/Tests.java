import framework.testBase.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;

public class Tests extends BaseTest {
    @Test
    public void test1() {
        ContactPage contactPage = new ContactPage();
        contactPage.openHomePage()
                .selectBusinessClient()
                .populateName("BlueServices Test")
                .populateEmail("bs@blueservices.pl")
                .populateCompanyName("automat BlueServices")
                .populatePhoneNumber("+48 123 123 123")
//                .selectValueFromList("Przelewy natychmiastowe")
                .populateBody("chce otrzymac odpowiedz na e-mail")
                .clickOnEmailResponseButton()
                .checkDataProcessingAgreementCheckbox();
    }

    @DataProvider(name = "testData")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"BlueServices Test",
                "bs@blueservices.pl",
                "automat BlueServices",
                "+48 123 123 123",
                "Przelewy natychmiastowe",
                "chce otrzymac odpowiedz na e-mail"}};
    }

    @Test(dataProvider = "testData")
    public void test2(String name, String email, String companyName, String phoneNumber, String topic, String freeText) {
        ContactPage contactPage = new ContactPage();
        contactPage.openHomePage()
                .selectBusinessClient()
                .populateName(name)
                .populateEmail(email)
                .populateCompanyName(companyName)
                .populatePhoneNumber(phoneNumber)
//                .selectValueFromList(topic)
                .populateBody(freeText)
                .clickOnEmailResponseButton()
                .checkDataProcessingAgreementCheckbox();
    }
}
