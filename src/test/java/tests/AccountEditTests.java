package tests;

import org.junit.jupiter.api.Test;

import static auth.Auth.authCookiesKey;
import static io.restassured.RestAssured.given;

public class AccountEditTests extends TestBase {

    @Test
    void addNewAddressTest() {

        String valueId = "0",
                valueFirstName = "Brown",
                valueLastName = "Smith",
                valueEmail = "b.smith123@test.com",
                valueCompany = "Orbit",
                valueCountryId = "1",
                valueStateProvinceId = "54",
                valueCity = "Austin",
                valueAddress1 = "Hoover1",
                valueAddress2 = "Pack2",
                valueZipPostalCode = "090909",
                valuePhoneNumber = "3798989898",
                valueFaxNumber = "";

        String authCookiesValue = auth.getAuthCookies(login, password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookiesKey, authCookiesValue)
                .formParam("Address.Id", valueId)
                .formParam("Address.FirstName", valueFirstName)
                .formParam("Address.LastName", valueLastName)
                .formParam("Address.Email", valueEmail)
                .formParam("Address.Company", valueCompany)
                .formParam("Address.CountryId", valueCountryId)
                .formParam("Address.StateProvinceId", valueStateProvinceId)
                .formParam("Address.City", valueCity)
                .formParam("Address.Address1", valueAddress1)
                .formParam("Address.Address2", valueAddress2)
                .formParam("Address.ZipPostalCode", valueZipPostalCode)
                .formParam("Address.PhoneNumber", valuePhoneNumber)
                .formParam("Address.FaxNumber", valueFaxNumber)
                .when()
                .post("/customer/addressedit/3124028")
                .then()
                .log().all()
                .assertThat()
                .statusCode(302);

    }

    @Test
    void editAddressTest() {

        String valueId = "3124028",
                valueFirstName = "Brown007",
                valueLastName = "Smith007",
                valueEmail = "b.smith007@test.com",
                valueCompany = "Orbit123",
                valueCountryId = "1",
                valueStateProvinceId = "54",
                valueCity = "Austin123",
                valueAddress1 = "Hoover123",
                valueAddress2 = "Pack213",
                valueZipPostalCode = "090910",
                valuePhoneNumber = "3798989810",
                valueFaxNumber = "";

        String authCookiesValue = auth.getAuthCookies(login, password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookiesKey, authCookiesValue)
                .formParam("Address.Id", valueId)
                .formParam("Address.FirstName", valueFirstName)
                .formParam("Address.LastName", valueLastName)
                .formParam("Address.Email", valueEmail)
                .formParam("Address.Company", valueCompany)
                .formParam("Address.CountryId", valueCountryId)
                .formParam("Address.StateProvinceId", valueStateProvinceId)
                .formParam("Address.City", valueCity)
                .formParam("Address.Address1", valueAddress1)
                .formParam("Address.Address2", valueAddress2)
                .formParam("Address.ZipPostalCode", valueZipPostalCode)
                .formParam("Address.PhoneNumber", valuePhoneNumber)
                .formParam("Address.FaxNumber", valueFaxNumber)
                .when()
                .post("/customer/addressedit/3124028")
                .then()
                .log().all()
                .assertThat()
                .statusCode(302);


    }



}
