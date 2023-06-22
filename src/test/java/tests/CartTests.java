package tests;


import models.AddToCartResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static auth.Auth.authCookiesKey;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTests extends TestBase {
    String authCookiesValue;
    int numberOfItems;
    int quantity = 3;
    String data = "product_attribute_72_5_18=52" +
            "&product_attribute_72_6_19=54" +
            "&product_attribute_72_3_20=58" +
            "&addtocart_72.EnteredQuantity=" + quantity;

    @Test
    void addToCartAsAuthorizedTest() {
        step("Get authorization cookie by api and set it to browser", () ->
                authCookiesValue = auth.getAuthCookies(login, password));

        step("Get the number of items in the cart", () -> {
            String page = given()
                    .cookie(authCookiesKey, authCookiesValue)
                    .when()
                    .get()
                    .then()
                    .statusCode(200)
                    .extract()
                    .asString();

            Document doc = Jsoup.parse(page);
            String count = doc.select(".cart-qty").text();
            numberOfItems = Integer.parseInt(count.replaceAll("[()]", ""));
        });

        AddToCartResponse response = step("Add items to cart", () -> given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(authCookiesKey, authCookiesValue)
                .body(data)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(AddToCartResponse.class));

        step("Check adding items to cart", () -> {
            assertThat(response.getSuccess()).isEqualTo("true");
            assertThat(response.getMessage()).isEqualTo("The product has been added to your <a href=\"/cart\">shopping cart</a>");
            assertThat(response.getUpdatetopcartsectionhtml()).isEqualTo("(" + (numberOfItems + quantity) + ")");
        });
    }

    @Test
    void addToCartAsAnonymTest() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(data)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(3)"));
    }
}


            /*
            1. Выполнить логин через api
            2. Открыть кастомер инфо через API
            3. Отредакировать personal details
            */