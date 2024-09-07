package API.Endpoints;


import io.restassured.response.Response;
import java.util.Map;

import static API.Factory.Enviroment.BaseUrl;
import static API.Factory.RequestFactory.CreateRequest;

public class PetEndPoint {
    private static final String BASE_URL = BaseUrl;

    public Response CreatePet(Map<String, Object> PetPayLoad) {
        return CreateRequest()
                .baseUri(BASE_URL + "/pet")
                .body(PetPayLoad)
                .when()
                .post();
    }

    public Response UpdatePet(Map<String, Object> PetPayLoad) {
        return CreateRequest()
                .baseUri(BASE_URL + "/pet")
                .body(PetPayLoad)
                .when()
                .put();
    }

    public Response FindPetByStatus(String status) {
        return CreateRequest()
                .baseUri(BASE_URL + "/pet/findByStatus")
                .queryParam("status",status)
                .when()
                .get();
    }

    public Response FindPetById(String id) {
        return CreateRequest()
                .baseUri(BASE_URL + "/pet")
                .when()
                .get("/" + id);
    }

    public Response DeletePet(String id) {
        return CreateRequest()
                .baseUri(BASE_URL + "/pet")
                .when()
                .delete("/" + id);
    }



}
