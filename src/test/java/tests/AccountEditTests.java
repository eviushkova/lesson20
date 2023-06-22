package tests;

import org.junit.jupiter.api.Test;

import static auth.Auth.authCookiesKey;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class AccountEditTests extends TestBase {

    @Test
    void addNewAddressTest() {

        AddressData addressData = AddressData.builder().build();

        String authCookiesValue = auth.getAuthCookies(login, password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookiesKey, authCookiesValue)
                .formParam("Address.Id", addressData.getId())
                .formParam("Address.FirstName", addressData.getFirstName())
                .formParam("Address.LastName", addressData.getLastName())
                .formParam("Address.Email", addressData.getEmail())
                .formParam("Address.Company", addressData.getCompany())
                .formParam("Address.CountryId", addressData.getCountryId())
                .formParam("Address.StateProvinceId", addressData.getStateProvinceId())
                .formParam("Address.City", addressData.getCity())
                .formParam("Address.Address1", addressData.getAddress1())
                .formParam("Address.Address2", addressData.getAddress2())
                .formParam("Address.ZipPostalCode", addressData.getZipPostalCode())
                .formParam("Address.PhoneNumber", addressData.getPhoneNumber())
                .formParam("Address.FaxNumber", addressData.getFaxNumber())
                .when()
                .post("/customer/addressedit/3124028")
                .then()
                .log().all()
                .assertThat()
                .statusCode(302);

    }

    @Test
    void editAddressTest() {

        var ad = AddressData.builder()
                .id("3124028")
                .firstName("Brown007")
                .lastName("Smith007")
                .email("b.smith007@test.com")
                .company("Orbit123")
                .countryId("1")
                .stateProvinceId("54")
                .city("Austin123")
                .address1("Hoover123")
                .address2("Pack213")
                .zipPostalCode("090910")
                .phoneNumber("3798989810")
                .faxNumber("")
                .build();

        String authCookiesValue = auth.getAuthCookies(login, password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookiesKey, authCookiesValue)
                .formParam("Address.Id", ad.getId())
                .formParam("Address.FirstName", ad.getFirstName())
                .formParam("Address.LastName", ad.getLastName())
                .formParam("Address.Email", ad.getEmail())
                .formParam("Address.Company", ad.getCompany())
                .formParam("Address.CountryId", ad.getCountryId())
                .formParam("Address.StateProvinceId", ad.getStateProvinceId())
                .formParam("Address.City", ad.getCity())
                .formParam("Address.Address1", ad.getAddress1())
                .formParam("Address.Address2", ad.getAddress2())
                .formParam("Address.ZipPostalCode", ad.getZipPostalCode())
                .formParam("Address.PhoneNumber", ad.getPhoneNumber())
                .formParam("Address.FaxNumber", ad.getFaxNumber())
                .when()
                .post("/customer/addressedit/3124028")
                .then()
                .log().all()
                .assertThat()
                .statusCode(302);
    }

    @Test
    void changePersonalDetails() throws InterruptedException {
        step("Open login page", () ->
                open("/login"));
        step("Fill login form", () -> {
            $("#Email").setValue(login);
            $("#Password").setValue(password).pressEnter();
        });
        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));
        step("Open customer info", () ->
                $(".account").click());
        step("Open addresses", () ->
                $(".listbox").$(byText("Addresses")).click());

        var ad = AddressData.builder()
                .id("3124028")
                .firstName("Amy")
                .lastName("Adams")
                .email("b.smith007@test.com")
                .company("Orbit123")
                .countryId("1")
                .stateProvinceId("54")
                .city("Austin123")
                .address1("Hoover123")
                .address2("Pack213")
                .zipPostalCode("090910")
                .phoneNumber("3798989810")
                .faxNumber("")
                .build();

        String authCookiesValue = auth.getAuthCookies(login, password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookiesKey, authCookiesValue)
                .formParam("Address.Id", ad.getId())
                .formParam("Address.FirstName", ad.getFirstName())
                .formParam("Address.LastName", ad.getLastName())
                .formParam("Address.Email", ad.getEmail())
                .formParam("Address.Company", ad.getCompany())
                .formParam("Address.CountryId", ad.getCountryId())
                .formParam("Address.StateProvinceId", ad.getStateProvinceId())
                .formParam("Address.City", ad.getCity())
                .formParam("Address.Address1", ad.getAddress1())
                .formParam("Address.Address2", ad.getAddress2())
                .formParam("Address.ZipPostalCode", ad.getZipPostalCode())
                .formParam("Address.PhoneNumber", ad.getPhoneNumber())
                .formParam("Address.FaxNumber", ad.getFaxNumber())
                .when()
                .post("/customer/addressedit/3124028")
                .then()
                .log().all()
                .assertThat()
                .statusCode(302);

        Thread.sleep(2000);

        step("Reload page", () ->
                open("/customer/addresses"));
        step("Check edited customer title", () ->
                $(".title").$(byText("Amy Adams")));
    }
}
