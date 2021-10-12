package AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage{

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='main-page']/div[1]/div/div[4]/nav/div/ul")
     WebElement menuItems;

    @FindBy(xpath = "//*[@id='main-page']/div[1]/div/div[4]/nav/div/ul/li[9]/div/div[1]/ul")
    WebElement insuranceItems;

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath(".//*[contains(text(), '"+itemName+"')]")).click();
    }
    public void selectInsuranceItem(String itemName) {
        insuranceItems.findElement(By.xpath(".//*[contains(text(), '"+itemName+"')]")).click();
    }
}
