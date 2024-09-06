package Tests;

import API.Builders.Pet.PetPayloadBuilder;
import API.Endpoints.Pet.PetEndPoint;
import org.testng.annotations.Test;


public class PetTests {
    private final PetEndPoint petEndPoint = new PetEndPoint();

    @Test
    public void CreatePet() {


        String[] photoUrls = {"https://i0.statig.com.br/bancodeimagens/78/pt/gs/78ptgsfeddfh638dkkzya5p3y.jpg"};


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
