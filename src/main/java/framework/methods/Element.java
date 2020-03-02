package framework.methods;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element {
    private WebDriver driver = BaseDriver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public void click() {
        waitUntilClickable().click();
    }

    public void enterText(String text) {
        waitUntilVisible().sendKeys(text);
    }

    public void pressEnter() {
        waitUntilVisible().sendKeys(Keys.ENTER);
    }

    public void selectFromList(String requiredValue) {
        for (WebElement element : getElements()) {
            System.out.println("Tekst elementu: " + element.getText());
            if (element.getText().equals(requiredValue)) {
                element.click();
                break;
            }
        }
    }

    public boolean isDisplayed() {
        return waitUntilVisible().isDisplayed();
    }

    private WebElement waitUntilClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitUntilVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> getElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }
}
