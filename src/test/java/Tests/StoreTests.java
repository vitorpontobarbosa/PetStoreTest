package Tests;

import API.Builders.OrderPayloadBuilder;
import API.Endpoints.OrderEndPoint;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class StoreTests {

    private final OrderEndPoint orderEndPoint = new OrderEndPoint();

    @Test
    public void CreateOrder() {
        OrderPayloadBuilder orderPayload = new OrderPayloadBuilder()
                .withQuantity(100)
                .withComplete(true);

        orderEndPoint.createOrder(orderPayload.build())
                .then()
                .statusCode(200)
                .log().body(true)
                .body("id",notNullValue())
                .body("quantity", equalTo("200"))
                .body("complete", equalTo("true"));
    }
}
