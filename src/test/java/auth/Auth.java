package auth;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class Auth {

    public static String authCookiesKey = "NOPCOMMERCE.AUTH";

    public String getAuthCookies(String login, String password) {

        return given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract()
                .cookie(authCookiesKey);
    }
}
