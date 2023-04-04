package com.gostechnadzor;

import com.gostechnadzor.insert_data.InsertingMainData;
import com.gostechnadzor.test_base.TestBase;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Owner("c@tcat4er")
@DisplayName("Test lk GosTechNadzor")
public class TestWPO extends TestBase {


    InsertingMainData PersonalData = ConfigFactory.create(InsertingMainData.class);
    String login = PersonalData.login();
    String password = PersonalData.password();
    String site_port = PersonalData.site_port();


    @Test
    public void openMainPagePositive() {

        loginPage
                .openBrowser(site_port)
                .login(login, password)
                .assertTrueLogin();
    }

    @Test
    public void openMainPageNegative() {

        loginPage
                .openBrowser(site_port)
                .login("wronglogin", password)
                .assertFalseLogin();
    }

    @Test
    public void testForm() {

        loginPage
                .openBrowser(site_port)
                .login(login, password)
                .assertTrueLogin();
        mainPage
                .pressOperationButton()
                .pressListOfPeople()
                .pressAddButton()
                .pressAddIndividualBtn()
                .assertIndividualPageOpen();
        individualModal
                .addName("Имя")
                .addSurname("Фамилия")
                .addTIN("650110509000")
                .addGender("Ж")
                .addCitizenship("Ангола")
                .addBirthplace("Место рождения")
                .addBirthDate("21", "мая", "1990")
                .addLocation("Пенз", "пенз", "пенз");
    }

}
