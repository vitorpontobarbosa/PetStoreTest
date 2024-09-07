package Tests;

import API.Builders.OrderPayloadBuilder;
import API.Endpoints.OrderEndPoint;
import org.testng.annotations.Test;

public class StoreTests{

    private final OrderEndPoint orderEndPoint = new OrderEndPoint();

    @Test
    public void CreateOrder(){
        OrderPayloadBuilder orderPayload = new OrderPayloadBuilder()
                .withQuantity(5)
                .withQuantity(10)
                .withComplete(true)
                .withStatus("placed");

        orderEndPoint.createOrder(orderPayload.build())
                .then()
                .statusCode(200);
    }
}
