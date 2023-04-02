package com.gostechnadzor;

import com.gostechnadzor.insert_data.InsertData;
import com.gostechnadzor.test_base.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class TestWPO extends TestBase {

    InsertData InsData = new InsertData();

    @Test
    public void openMainPagePositive(){
        InsData
                .openBrowser(":23480")
                .login("TEST", "Test1")
                .assertTrueLogin();
    }

    @Test
    public void openMainPageNegative(){
        InsData
                .openBrowser(":23480")
                .login("TEST", "Text1")
                .assertFalseLogin();
    }

    @Test
    public void testForm(){
        InsData
                .openBrowser(":23480")
                .login("TEST", "Test1")
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
