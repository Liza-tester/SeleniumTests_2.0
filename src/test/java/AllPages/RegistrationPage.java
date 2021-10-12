package AllPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.HashMap;
import java.util.Map;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        fill_map();
    }


    @FindBy(id = "surname_vzr_ins_0")
    WebElement lastName_0;
    @FindBy(id = "name_vzr_ins_0")
    WebElement firstName_0;
    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate_0;

    @FindBy(id = "person_lastName")
    WebElement lastName;
    @FindBy(id = "person_firstName")
    WebElement firstName;
    @FindBy(id = "person_middleName")
    WebElement middleName;
    @FindBy(id = "person_birthDate")
    WebElement birthDate;
    @FindBy(xpath = "//div[5]/div/form-control-label/div/radio-button-group/div/div")
    WebElement sex;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;
    @FindBy(id = "passportNumber")
    WebElement passportNumber;
    @FindBy(id = "documentIssue")
    WebElement documentIssue;
    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "email")
    WebElement email_1;
    @FindBy(id = "repeatEmail")
    WebElement email_2;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    WebElement buttonContinue;

    Map<String, WebElement> map = new HashMap<>();

    public void fill_map(){
        map.put("Фамилия застрахованного", lastName_0);
        map.put("Имя застрахованного", firstName_0);
        map.put("Дата рождения застрахованного", birthDate_0);

        map.put("Фамилия",lastName);
        map.put("Имя", firstName);
        map.put("Отчество", middleName);
        map.put("Дата рождения", birthDate);
        map.put("Пол", sex);

        map.put("Серия паспорта", passportSeries);
        map.put("Номер паспорта", passportNumber);
        map.put("Дата выдачи паспорта", documentDate);
        map.put("Кем выдан паспорт", documentIssue);

        map.put("Мобильный телефон", phone);
        map.put("Электронная почта", email_1);
        map.put("Повтор электронной почты", email_2);

    }

    public void checkFieldValue(String field, String value) {
        if (field.equals("Пол"))
            Assert.assertEquals(value,
                    sex.findElement(By.xpath(".//label[contains(text(),'" + value + "')]")).getText());
        else Assert.assertEquals(value, getField(map.get(field)));
    }
    public void fillField(String field, String value){
        if (field.equals("Пол")){
            sex.findElement(By.xpath(".//label[contains(text(),'" + value + "')]")).click();}
        else{
            setField(map.get(field), value);
             if (field.startsWith("Дата")) lastName.click();
        }
    }
    public void pressContinue(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonContinue);
        buttonContinue.click();
    }
    public void checkNotifications(){
        Assert.assertEquals("Поле не заполнено.", driver.findElement(
                By.xpath("//input-phone2/span/validation-message/span")).getText());
        Assert.assertEquals("Поле не заполнено.", driver.findElement(
                By.xpath("//div[2]//input-email/span/validation-message/span")).getText());
        Assert.assertEquals("Поле не заполнено.", driver.findElement(
                By.xpath("//div[3]//input-email/span/validation-message/span")).getText());
        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(
                By.xpath("//*[contains(@role,'alert-form')]")).getText());
    }
}