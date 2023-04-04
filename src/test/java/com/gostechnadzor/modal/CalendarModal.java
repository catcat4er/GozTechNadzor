package com.gostechnadzor.modal;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarModal {

    @Step("Ввод даты")
    public void setDate(String day, String month, String year) {
        $("[ng-model='person.BirthDate']").click();
        $("[style='text-transform:capitalize']").doubleClick();
        $(".glyphicon-chevron-left").click();
        $(".glyphicon-chevron-left").doubleClick();
        $$(".dropdown-menu.datepicker span").findBy(text(year)).click();
        $$(".dropdown-menu.datepicker span").findBy(text(month)).click();
        $$(".dropdown-menu.datepicker span").findBy(text(day)).click();
    }

}
