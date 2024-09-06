package API.Builders.Store;

import java.util.HashMap;
import java.util.Map;

public class OrderPayloadBuilder {
    private Map<String, Object> OrderPayLoad = new HashMap<>();

    public OrderPayloadBuilder withId(String id) {
        OrderPayLoad.put("id", id);
        return this;
    }

    public OrderPayloadBuilder withPetId(String petId) {
        OrderPayLoad.put("petId", petId);
        return this;
    }

    public OrderPayloadBuilder withQuantity(int quantity) {
        OrderPayLoad.put("quantity", quantity);
        return this;
    }

    public OrderPayloadBuilder withShipDate(String shipDate) {
        OrderPayLoad.put("shipDate", shipDate);
        return this;
    }

    public OrderPayloadBuilder withStatus(String status) {
        OrderPayLoad.put("status", status);
        return this;
    }

    public OrderPayloadBuilder withComplete(boolean complete) {
        OrderPayLoad.put("complete", complete);
        return this;
    }

    public Map<String, Object> build() {
        return OrderPayLoad;
    }

}
