package com.gostechnadzor.modal;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarModal {


    SelenideElement calendarHeadWithYear = $("[ng-model='person.BirthDate']");
    SelenideElement calendarHeadWithMonth = $("[style='text-transform:capitalize']");
    SelenideElement leftSwitchingArrow = $(".glyphicon-chevron-left");
    ElementsCollection calendarField = $$(".dropdown-menu.datepicker span");

    @Step("Ввод даты")
    public void setDate(String day, String month, String year) {
        calendarHeadWithYear.click();
        calendarHeadWithMonth.doubleClick();
        leftSwitchingArrow.click();
        leftSwitchingArrow.doubleClick();
        calendarField.findBy(text(year)).click();
        calendarField.findBy(text(month)).click();
        calendarField.findBy(text(day)).click();
    }

}
