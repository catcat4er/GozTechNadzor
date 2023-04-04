package com.gostechnadzor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String FAIL_TEXT = "Неверный логин или пароль.";
    private final String ACCEPTANCE_TEXT = "Поиск владельца";

    SelenideElement loginField = $("#inputLogin");
    SelenideElement passwordField = $("#inputPassword");
    SelenideElement loginButton = $("#loginButton");
    SelenideElement checkedFieldForAcceptance = $("#loginButton");

    @Step("Запускаем браузер с указанием необходимой страницы")
    public LoginPage openBrowser(String site) {
        open(site);
        return this;
    }

    @Step("Производим вход в лк")
    public LoginPage login(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
        sleep(3000);
        return this;
    }

    @Step("Подтверждение правильного ввода логина и пароля")
    public LoginPage assertTrueLogin() {
        checkedFieldForAcceptance.shouldHave(text(ACCEPTANCE_TEXT));
        return this;
    }

    @Step("Подтверждение неправильного ввода логина и пароля")
    public LoginPage assertFalseLogin() {
        $("#Password").shouldHave(text(FAIL_TEXT));
        return this;
    }
}
