package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class GetRequest02 {
    @Test
    public void get01() {

        String url="https://reqres.in/api/users";
        Response response=given().when().get(url);

        //Header Test

        response.
                then().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON).
                header("Server","cloudflare");


        //Body Test
        /*id=1 olanin datalarinin asagidaki gibi oldugunu test ediniz
         "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

        //3)Matcher Class ile API testi yapabiliyoruz
        /*
        data[0] id=1 olan demek index olarak
         */
        response.then().body("data[0].email",equalTo("george.bluth@reqres.in"),
                "data[0].first_name",equalTo("George"),
                "data[0].last_name",equalTo("Bluth"));



    }
}
