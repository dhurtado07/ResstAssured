import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.urlEncodingEnabled;

public class MyFirstRestAssuredClass {
    @Test
    public void getResponseBody(){
        given().
                when().
                get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").
                then().
                log().
                all();
    }
    @Test
    public void GetResponseBodyParam(){
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php")
                .then()
                .log()
                .body();
    }
    @Test
    public void getResponseStatus(){
        String url = "http://demo.guru99.com/V4/sinkministatement.php";
       int statusCode = given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get(url).getStatusCode();

        given().when().get(url).then().assertThat().statusCode(200);

       System.out.println("The response status is: "+statusCode);

    }
}
