package tests;

import auth.Auth;
import com.codeborne.selenide.Configuration;
import config.AppConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
    String login = config.getLogin();
    String password = config.getPassword();
    Auth auth = new Auth();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = config.getBaseUrl();
        RestAssured.baseURI = config.getBaseUrl();
    }
}
