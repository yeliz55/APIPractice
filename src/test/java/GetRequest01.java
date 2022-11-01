import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {

    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking";
        Response response=given().when().get(url);

        //given().when().get(url) ==> bunu yaparak endpointe gondermek icin request olusturduk
        // Response respone ==> api tarafindan bana donen cevap


        // Response response =given().auth().basic("user","password").when().get(url);
        //basic auth ile request gondermek icin

       //response.prettyPrint(); //response'daki Body'i yazdirir
       // response.prettyPeek(); //Headerda ne var ne yok hepsini yazdirir(response daki herseyi yazdirir)
       // response.peek(); //Tum veriyi String olarak yazdırır
       // response.print();//sadece body'i  string olarak tek satirda veriyor

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.statusLine() = " + response.statusLine());


        //1)JUnit assertleri ile API testi yapabiliriz
        Assert.assertEquals("Status code hatali",200,response.statusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());

        //2)assertthat ile API testi yapabiliriz
        response.
                then().
                assertThat().//assertThat kullanmasakta olur
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");



    }
}
