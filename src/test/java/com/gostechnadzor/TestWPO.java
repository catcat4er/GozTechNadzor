package com.gostechnadzor;

import com.gostechnadzor.insert_data.InsertData;
import com.gostechnadzor.insert_data.InsertingMainData;
import com.gostechnadzor.test_base.TestBase;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Owner("c@tcat4er")
@DisplayName("Test lk GosTechNadzor")
public class TestWPO extends TestBase {

    InsertData InsData = new InsertData();
    InsertingMainData PersonalData = ConfigFactory.create(InsertingMainData.class);
    String login = PersonalData.login();
    String password = PersonalData.password();
    String site_port = PersonalData.site_port();


    @Test
    public void openMainPagePositive(){
        InsData
                .openBrowser(site_port)
                .login(login, password)
                .assertTrueLogin();
    }

    @Test
    public void openMainPageNegative(){
        InsData
                .openBrowser(site_port)
                .login(login, password)
                .assertFalseLogin();
    }

    @Test
    public void testForm(){
        InsData
                .openBrowser(site_port)
                .login(login, password)
                .assertTrueLogin()
                .addIndividual()
                .addName("Имя")
                .addSurname("Фамилия")
                .addTIN("650110509000")
                .addCitizenship("Ангола")
                .addBirthplace("Место рождения")
                .addGender("Ж")
                .addBirthDate("21","фев","1990");
    }

}
