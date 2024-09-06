package Tests;

import Bases.TestBase;
import org.testng.annotations.Test;


import java.io.IOException;

import static io.restassured.RestAssured.*;

public class StoreTests extends TestBase {

    @Test
    public void StoreOrderSuccess() throws IOException {

        String JsonBody = ReadJson("StoreJsons/Order.Json");

        given()
                .contentType("application/json")
               .body(JsonBody)
        .when()
                .post(BaseUrl + "store/order")
        .then()
                .log().body(true)
                .statusCode(200)
                ;

    }
}
