package Tests;

import API.Builders.PetPayloadBuilder;
import API.Endpoints.PetEndPoint;
import API.Factory.GeneratorUtils;
import jdk.jfr.Name;
import org.testng.annotations.Test;


public class PetTests {
    public static String petIdResponse;
    private final PetEndPoint petEndPoint = new PetEndPoint();

    @Test
    @Name( "Criar um novo pet")
    public void CreatePet() {
        String[] photoUrls = {"cachorro.jpg"};

        PetPayloadBuilder petPayload = new PetPayloadBuilder()
                .withName(GeneratorUtils.generateString(5))
                .withPhotoUrls(photoUrls)
                .withStatus("pending");

        petIdResponse = petEndPoint.CreatePet(petPayload.build())
                .then()
                .log().body(true)
                .statusCode(200)
                .extract().path("id").toString();

    }

    @Test(dependsOnMethods = "CreatePet")
    @Name( "Deletar um pet")
    public void DeletePet() {
        petEndPoint.DeletePet(petIdResponse)
                .then()
                .log().body(true)
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"CreatePet", "DeletePet"})
    @Name( "Busca um pet inexistente")
    public void GetPetNotfound() {
        petEndPoint.FindPetById(petIdResponse)
                .then()
                .log().body(true)
                .statusCode(404);
    }

    @Test(dependsOnMethods = "CreatePet")
    @Name( "Busca Pet pelo Status Pending")
    public void GetPetPending() {
        petEndPoint.FindPetByStatus("pending")
                .then()
                .log().body(true)
                .statusCode(200);
    }

    @Test(dependsOnMethods = "CreatePet")
    @Name( "Atualiza o pet")
    public void UpdatePet() {
        String[] photoUrls = {"cachorroUpdated.jpg"};

        PetPayloadBuilder petPayload = new PetPayloadBuilder()
                .withName(GeneratorUtils.generateString(5))
                .withPhotoUrls(photoUrls)
                .withStatus("available")
                .withId(petIdResponse);

        petEndPoint.UpdatePet(petPayload.build())
                .then()
                .log().body(true)
                .statusCode(200);
    }
}