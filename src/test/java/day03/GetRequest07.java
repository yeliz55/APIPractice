package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class GetRequest07 extends GMIBankBaseUrl {
   /* http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
            “firstName”: “Melva”,
            “lastName”: “Bernhard”,
            “email”: “chas.kuhlman@yahoo.com”
            “zipCode”: “40207"
            “country” “name”: “San Jose”
            “login”: “delilah.metz”*/

    @Test
    public void get01() {
        //Set The Url
        spec.pathParams("first","tp-customers","second",110472);
        //Set The Expected Data

        //Send The Request and Get The Response
        Response response=given().spec(spec).
                headers("Authorization","Bearer "+generateToken()).
                when().get("/{first}/{second}");
        response.prettyPrint();
        //Matcher ile dogrulama
        response.then().assertThat().
                body("firstName",equalTo("Melva"),
                        "lastName",equalTo("Bernhard"),
                        "email",equalTo("chas.kuhlman@yahoo.com"),
                        "zipCode",equalTo("40207"),
                        "country.name",equalTo("San Jose"),
                        "user.login",equalTo("delilah.metz"));

        //Json Path ile dogrula
        JsonPath jsonPath=response.jsonPath();
        assertEquals("Melva",jsonPath.getString("firstName"));
        assertEquals("Bernhard",jsonPath.getString("lastName"));
        assertEquals("chas.kuhlman@yahoo.com",jsonPath.getString("email"));
        assertEquals("40207",jsonPath.getString("zipCode"));
        assertEquals("San Jose",jsonPath.getString("country.name"));
        assertEquals("delilah.metz",jsonPath.getString("user.login"));


    }
}
