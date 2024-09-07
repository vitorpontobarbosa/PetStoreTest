package Tests;

import API.Builders.PetPayloadBuilder;
import API.Endpoints.PetEndPoint;
import org.testng.annotations.Test;


public class PetTests {
    private final PetEndPoint petEndPoint = new PetEndPoint();

    @Test
    public void CreatePet() {
        String[] photoUrls = {"cachorro.jpg"};

        PetPayloadBuilder petPayload = new PetPayloadBuilder()
                .withName("junin")
                .withPhotoUrls(photoUrls);

        petEndPoint.CreatePet(petPayload.build())
                .then()
                .log().body(true)
                .statusCode(200)
        ;
    }
}
