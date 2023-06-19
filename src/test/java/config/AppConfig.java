package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/properties"
})
public interface AppConfig extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseUrl")
    String getBaseUrl();

}
