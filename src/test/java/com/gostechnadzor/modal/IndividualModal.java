package com.gostechnadzor.modal;

import com.gostechnadzor.insert_data.InsertData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class IndividualModal {
    CalendarModal calendarModal = new CalendarModal();

    @Step("Ввод имени")
    public IndividualModal addName (String name) {
        $("[selectedobject='person.Firstname'] input").setValue(name);     //имя
        return this;
    }
    @Step("Ввод фамилии")
    public IndividualModal addSurname (String surname) {
        $("[selectedobject='person.Surname'] input").setValue(surname);
        return this;

    }
    @Step("Ввод ИНН")
    public IndividualModal addTIN (String tin) {
        $("[ng-model='person.Inn']").setValue(tin);  //инн
        return this;
    }
    @Step("Ввод гражданства")
    public IndividualModal addCitizenship (String citizenship) {
        $("[property-name='person.Citizenship_Id'] .chosen-single").click();
        $("[property-name='person.Citizenship_Id'] [type='text']").setValue(citizenship).pressEnter();
        return this;
    }
    @Step("Ввод места рождения")
    public IndividualModal addBirthplace (String birthplace) {
        $("[field-name='person.Birthplace']").click();
        $("[ng-model='address']").setValue(birthplace);
        $("[ng-click='ok()']").click();
        return this;
    }
    @Step("Ввод пола")
    public IndividualModal addGender (String gender) {
        $("[property-name='person.Sex'] .chosen-single").click();
        $("[property-name='person.Sex'] [type='text']").setValue(gender).pressEnter();
        return this;
    }
    @Step("Ввод Даты рождения")
    public IndividualModal addBirthDate (String day, String month, String year) {
        calendarModal.setDate(day, month, year);
        return this;
    }


}
