package framework.testBase;

import framework.driver.BaseDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    public BaseTest(){}

    @Parameters({"env"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        BaseDriver.instantiateWebDriver("Chrome");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        BaseDriver.quitDriver();
    }
}
