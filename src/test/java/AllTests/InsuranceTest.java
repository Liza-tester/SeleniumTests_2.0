package AllTests;

import AllPages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class InsuranceTest extends BaseTest {

    @Test
    public void testInsurance() throws InterruptedException {

        StartPage startPage = new StartPage(driver);
        startPage.selectMenuItem("Страхование");
        startPage.selectInsuranceItem("страховые программы");

        InsuranceProgramsPage insuranceProgramsPage= new InsuranceProgramsPage(driver);
        insuranceProgramsPage.selectInsuranceProgram("Страхование путешественников");

        TravelPage travelPage = new TravelPage(driver);
        Assert.assertEquals("Страхование путешественников", travelPage.getTitle());
        travelPage.checkoutOnline();
        travelPage.checkoutOnWebsite();

        SelectProduct selectProduct = new SelectProduct(driver);
        selectProduct.selectRegion("Все страны мира, кроме США и РФ");
        selectProduct.selectSum("Минимальная");
        selectProduct.checkout();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillField("Фамилия застрахованного", "Ivanov");
        registrationPage.fillField("Имя застрахованного", "Ivan");
        registrationPage.fillField("Дата рождения застрахованного", "02.02.1992");
        registrationPage.fillField("Фамилия", "Александрова");
        registrationPage.fillField("Имя", "Александра");
        registrationPage.fillField("Отчество", "Александровна");
        registrationPage.fillField("Дата рождения", "01.01.1991");
        registrationPage.fillField("Пол", "Женский");
        registrationPage.fillField("Серия паспорта","1111");
        registrationPage.fillField("Номер паспорта","123456");
        registrationPage.fillField("Дата выдачи паспорта","01.09.2020");
        registrationPage.fillField("Кем выдан паспорт","ЙЦУК №123");

        registrationPage.checkFieldValue("Фамилия застрахованного", "Ivanov");
        registrationPage.checkFieldValue("Имя застрахованного", "Ivan");
        registrationPage.checkFieldValue("Дата рождения застрахованного", "02.02.1992");
        registrationPage.checkFieldValue("Фамилия", "Александрова");
        registrationPage.checkFieldValue("Имя", "Александра");
        registrationPage.checkFieldValue("Отчество", "Александровна");
        registrationPage.checkFieldValue("Дата рождения", "01.01.1991");
        registrationPage.checkFieldValue("Пол", "Женский");
        registrationPage.checkFieldValue("Серия паспорта","1111");
        registrationPage.checkFieldValue("Номер паспорта","123456");
        registrationPage.checkFieldValue("Дата выдачи паспорта","01.09.2020");
        registrationPage.checkFieldValue("Кем выдан паспорт","ЙЦУК №123");
        registrationPage.checkFieldValue("Мобильный телефон", "");
        registrationPage.checkFieldValue("Электронная почта", "");
        registrationPage.checkFieldValue("Повтор электронной почты", "");

        registrationPage.pressContinue();
        registrationPage.checkNotifications();

        Thread.sleep(5000);

    }
}