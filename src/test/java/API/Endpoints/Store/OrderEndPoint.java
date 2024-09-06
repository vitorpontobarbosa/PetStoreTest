package API.Endpoints.Store;

import io.restassured.response.Response;

import java.util.Map;

import static API.Factory.RequestFactory.*;

import static io.restassured.RestAssured.given;

import API.Factory.Enviroment;

public class OrderEndPoint {


    private static final String BASE_URL = Enviroment.BaseUrl;

    public Response createOrder(Map<String, Object> OrderPayload) {
        return CreateRequest()
                .baseUri(BASE_URL + "/store/order")
                .body(OrderPayload)
                .when()
                .post();
    }

    public Response GetOrderById(int OrderId) {
        return given()
                .baseUri(BASE_URL + "/store/order")
                .when()
                .get("/" + OrderId);
    }


}
