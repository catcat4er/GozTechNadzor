package com.gostechnadzor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final String INDIVIDUAL_LIST_TEXT = "Физическое лицо";

    SelenideElement operationButton = $(".operation");
    SelenideElement listOfPeople = $("[ng-show='isShow.PERSON']");
    SelenideElement addButton = $(".icon-add");
    SelenideElement addIndividual = $(".popup-fizlitso");
    SelenideElement checkedFieldForAcceptance = $(".modal-title");

    @Step("Нажать кнопку 'Операции'")
    public MainPage pressOperationButton() {
        operationButton.shouldBe(visible).click();
        return this;
    }
    @Step("Нажать кнопку 'Список лиц'")
    public MainPage pressListOfPeople() {
        listOfPeople.shouldBe(visible).click();
        return this;
    }
    @Step("Нажать кнопку 'Добавить'")
    public MainPage pressAddButton() {
        addButton.shouldBe(visible).click();
        return this;
    }
    @Step("Нажать кнопку 'Добавить физ.лицо'")
    public MainPage pressAddIndividualBtn() {
        addIndividual.shouldBe(visible).click();
        return this;
    }
    @Step("Проверка на открытие формы физ лица")
    public MainPage assertIndividualPageOpen() {
        checkedFieldForAcceptance.shouldHave(text(INDIVIDUAL_LIST_TEXT));
        return this;
    }



}
