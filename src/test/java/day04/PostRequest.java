package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPostPojo;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;

public class PostRequest extends GMIBankBaseUrl {
    /*
    https://www.gmibank.com/api/tp-countries
     */
    @Test
    public void post01() {
        spec.pathParam("first","tp-countries");
        CountryPostPojo countryPostPojo=new CountryPostPojo("Batch81");
        Response response=given().headers("Authorization","Bearer "+generateToken(),"Content-Type",ContentType.JSON).spec(spec).when().
                body(countryPostPojo).post("/{first}");
        response.prettyPrint();

    }
}
