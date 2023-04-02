package com.gostechnadzor.insert_data;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class InsertData {
    @Step("Запускаем браузер с указанием необходимой страницы")
    public InsertData openBrowser (String site) {
        open(site);
        return this;
    }
    @Step("Производим вход в лк")
    public InsertData login (String login, String password) {
        $("#inputLogin").setValue(login);
        $("#inputPassword").setValue(password);
        $("#loginButton").click();
        sleep (3000);
        return this;
    }
    @Step("Подтверждение правильного ввода логина и пароля")
    public InsertData assertTrueLogin () {
        $("[data-target='#filterPersonsDataForm']").shouldHave(text("Поиск владельца"));
        return this;
    }
    @Step("Подтверждение неправильного ввода логина и пароля")
    public InsertData assertFalseLogin () {
        $("#Password").shouldHave(text("Неверный логин или пароль."));
        return this;
    }

    @Step("Добавляем физическое лицо")
    public InsertData addIndividual () {
        $(".operation").click();
        $("[ng-show='isShow.PERSON']").click();
        $(".icon-add").click();
        $(".popup-fizlitso").click();
        $(".modal-title").shouldHave(text("Физическое лицо"));
        return this;
    }
    @Step("Ввод имени")
    public InsertData addName (String name) {
        $("[selectedobject='person.Firstname'] input").setValue(name);     //имя
        return this;
    }
    @Step("Ввод фамилии")
    public InsertData addSurname (String surname) {
        $("[selectedobject='person.Surname'] input").setValue(surname);
        return this;

    }
    @Step("Ввод ИНН")
    public InsertData addTIN (String tin) {
        $("[ng-model='person.Inn']").setValue(tin);  //инн
        return this;
    }
    @Step("Ввод гражданства")
    public InsertData addCitizenship (String citizenship) {
        $("[property-name='person.Citizenship_Id'] .chosen-single").click();
        $("[property-name='person.Citizenship_Id'] [type='text']").setValue(citizenship).pressEnter();
        return this;
    }
    @Step("Ввод места рождения")
    public InsertData addBirthplace (String birthplace) {
        $("[field-name='person.Birthplace']").click();
        $("[ng-model='address']").setValue(birthplace);
        $("[ng-click='ok()']").click();
        return this;
    }
    @Step("Ввод пола")
    public InsertData addGender (String gender) {
        $("[property-name='person.Sex'] .chosen-single").click();
        $("[property-name='person.Sex'] [type='text']").setValue(gender).pressEnter();
        return this;
    }
    @Step("Ввод даты рождения")
    public void addBirthDate (String day, String month, String year) {
        $("[ng-model='person.BirthDate']").click();
        $("[style='text-transform:capitalize']").doubleClick();
        $(".glyphicon-chevron-left").click();
        $(".glyphicon-chevron-left").doubleClick();
        $$(".dropdown-menu.datepicker span").findBy(text(year)).click();
        $$(".dropdown-menu.datepicker span").findBy(text(month)).click();
        $$(".dropdown-menu.datepicker span").findBy(text(day)).click();
    }
}
