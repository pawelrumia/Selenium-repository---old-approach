package framework.methods;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
    private WebDriver driver = BaseDriver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public void click() {
        clickOnElement();
    }

    public void enterText(String text) {
        waitUntilVisible().sendKeys(text);
    }

    public void selectFromListByVisibleText(By listLocator, String searchValue) {
        Select dropdown = new Select(driver.findElement(listLocator));
        dropdown.selectByVisibleText(searchValue);
    }

    public boolean isDisplayed() {
        return waitUntilVisible().isDisplayed();
    }

    private WebElement waitUntilVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickOnElement() {
        driver.findElement(locator).click();
    }
}
