package API.Factory;

import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class RequestFactory {
    public static RequestSpecification CreateRequest() {
        return given()
                .contentType("application/json")
                .log().all();
    }

}
