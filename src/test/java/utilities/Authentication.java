package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;



public class Authentication {
    public static void main(String[] args) {
        String guncelToken=generateToken();
        System.out.println(guncelToken);
    }

    public static String generateToken(){

        String username="Batch81";
        String password="Batch81+";
        Boolean rememberMe= true;
        /*
        {
  "password": "string",
  "rememberMe": true,
  "username": "string"
}
         */
        Map<String,Object> postBody=new HashMap<>();
        postBody.put("username",username);
        postBody.put("password",password);
        postBody.put("rememberMe",rememberMe);

        String endPoint="https://www.gmibank.com/api/authenticate";

        Response response=given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);
       //postmande token alırken yaptıgımız adımları sırası ıle yaptık
        JsonPath token=response.jsonPath();
        return token.getString("id_token");//id_token yani keyin value'sini getir diyoruz

    }
}
