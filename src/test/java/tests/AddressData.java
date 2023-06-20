package tests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressData {

    private String id = "0";
    private String firstName = "Brown";
    private String lastName = "Smith";
    private String email = "b.smith123@test.com";
    private String company = "Orbit";
    private String countryId = "1";
    private String stateProvinceId = "54";
    private String city = "Austin";
    private String address1 = "Hoover1";
    private String address2 = "Pack2";
    private String zipPostalCode = "090909";
    private String phoneNumber = "3798989898";
    private String faxNumber = "";
}
