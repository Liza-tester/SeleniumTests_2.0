package AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public void setField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public String getField(WebElement element) {
        return element.getAttribute("value");
    }
}
