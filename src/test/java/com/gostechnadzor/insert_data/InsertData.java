package com.gostechnadzor.insert_data;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class InsertData {







    @Step("Ввод места жительства")
    public InsertData addLocation (String region, String city, String street) {
        $("[field-name='person.ObjectAddress']").click();
        $("[property-name='address.Region.Code'] .chosen-single").click();
        $("[property-name='address.Region.Code'] [type='text']").setValue(region).pressEnter();
        $("[selectedobject='address.City.FullName'] input").setValue(city);
        $("[ng-repeat='result in results']").click();
        sleep(500);
        $("[savedobject='address.Street'] input").setValue(street);
        $("[ng-repeat='result in results']").click();
        $("[ng-click='ok()']").click();
        return this;
    }
}
