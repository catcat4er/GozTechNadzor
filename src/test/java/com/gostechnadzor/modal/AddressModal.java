package com.gostechnadzor.modal;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AddressModal {

    SelenideElement buttonOk = $("[ng-click='ok()']");
    SelenideElement regionField = $("[property-name='address.Region.Code'] .chosen-single");
    SelenideElement inputRegionField = $("[property-name='address.Region.Code'] [type='text']");
    SelenideElement cityField = $("[selectedobject='address.City.FullName'] input");
    SelenideElement firstAcceptableResult = $("[ng-repeat='result in results']");
    SelenideElement streetField = $("[savedobject='address.Street'] input");


    @Step("Ввод региона")
    public AddressModal setRegion(String region) {
        regionField.click();
        inputRegionField.setValue(region).pressEnter();
        return this;
    }

    @Step("Ввод города")
    public AddressModal setCity(String city) {
        cityField.setValue(city);
        firstAcceptableResult.click();
        sleep(500);
        return this;
    }

    @Step("Ввод улицы")
    public AddressModal setStreet(String street) {
        streetField.setValue(street);
        firstAcceptableResult.click();
        return this;
    }

    @Step("Подтверждение создания формы")
    public AddressModal pressOk () {
        buttonOk.click();
        return this;
    }
}




