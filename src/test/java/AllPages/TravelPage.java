package AllPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class TravelPage extends BasePage{

    public TravelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='page-main']/div[1]/div/div/div/div/div/div[1]/h1")
    WebElement title;

    @FindBy (xpath = "//span[contains(text(),'Оформить онлайн')]")
    WebElement buttonOnline;

    @FindBy (xpath = "//span[contains(text(),'Оформить на сайте')]")
    WebElement buttonOnWebsite;

    public String getTitle() {
        return title.getText();
    }

    public void checkoutOnline(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonOnline);
        buttonOnline.click();
    }

    public void checkoutOnWebsite(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonOnWebsite);
        buttonOnWebsite.click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
