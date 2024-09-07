package Tests;

import API.Builders.PetPayloadBuilder;
import API.Endpoints.PetEndPoint;
import API.Factory.GeneratorUtils;
import org.testng.annotations.Test;


public class PetTests {
    private String petIdResponse;
    private final PetEndPoint petEndPoint = new PetEndPoint();

    @Test
    public void CreatePet() {
        String[] photoUrls = {"cachorro.jpg"};

        PetPayloadBuilder petPayload = new PetPayloadBuilder()
                .withName(GeneratorUtils.generateString(5))
                .withPhotoUrls(photoUrls);

        petIdResponse =  petEndPoint.CreatePet(petPayload.build())
                .then()
                .log().body(true)
                .statusCode(200)
                .extract().path("id").toString();

    }

    @Test(dependsOnMethods = "CreatePet")
    public void DeletePet() {
        petEndPoint.DeletePet(petIdResponse)
                .then()
                .log().body(true)
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"CreatePet","DeletePet"})
    public void GetPetNotfound() {
        petEndPoint.FindPetById(petIdResponse)
                .then()
                .log().body(true)
                .statusCode(404);
    }
}
