package com.gostechnadzor.modal;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class IndividualModal {
    CalendarModal calendarModal = new CalendarModal();


    static SelenideElement buttonOk = $("[ng-click='ok()']");
    SelenideElement inputFirstname = $("[selectedobject='person.Firstname'] input");

    SelenideElement inputSurname = $("[selectedobject='person.Surname'] input");
    SelenideElement inputTIN = $("[ng-model='person.Inn']");
    SelenideElement citizenshipSearchField = $("[property-name='person.Citizenship_Id'] .chosen-single");
    SelenideElement inputCitizenshipSearchField = $("[property-name='person.Citizenship_Id'] [type='text']");
    SelenideElement birthplaceField = $("[field-name='person.Birthplace']");
    SelenideElement inputBirthplaceField = $("[ng-model='address']");
    SelenideElement genderField = $("[property-name='person.Sex'] .chosen-single");
    SelenideElement genderChooseField = $("[property-name='person.Sex'] [type='text']");

    SelenideElement addressField = $("[field-name='person.ObjectAddress']");

    @Step("Ввод имени")
    public IndividualModal addName (String name) {
        inputFirstname.setValue(name);
        return this;
    }

    @Step("Ввод фамилии")
    public IndividualModal addSurname (String surname) {
        inputSurname.setValue(surname);
        return this;

    }

    @Step("Ввод ИНН")
    public IndividualModal addTIN (String tin) {
        inputTIN.setValue(tin);
        return this;
    }

    @Step("Ввод гражданства")
    public IndividualModal addCitizenship (String citizenship) {
        citizenshipSearchField.click();
        inputCitizenshipSearchField.setValue(citizenship).pressEnter();
        return this;
    }

    @Step("Ввод места рождения")
    public IndividualModal addBirthplace (String birthplace) {
        birthplaceField.click();
        inputBirthplaceField.setValue(birthplace);
        buttonOk.click();
        return this;
    }

    @Step("Ввод пола")
    public IndividualModal addGender (String gender) {
        genderField.click();
        genderChooseField.setValue(gender).pressEnter();
        return this;
    }

    @Step("Ввод Даты рождения")
    public IndividualModal addBirthDate (String day, String month, String year) {
        calendarModal.setDate(day, month, year);
        return this;
    }

    @Step("Ввод места жительства")
    public IndividualModal addLocation () {
        addressField.click();
        return this;
    }
    @Step("Подтверждение создания формы")
    public static void pressOk() {
        buttonOk.click();
    }

}
