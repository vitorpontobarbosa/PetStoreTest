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
                .log().all()
                .body(JsonBody)
        .when()
                .post(BaseUrl + "/store/order")
        .then()
                .log().all()
                .statusCode(200);

    }
}
