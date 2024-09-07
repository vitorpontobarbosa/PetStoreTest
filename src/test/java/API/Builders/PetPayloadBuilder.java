package API.Builders;

import java.util.HashMap;
import java.util.Map;

public class PetPayloadBuilder {
     private final Map<String, Object> PetPayLoad = new HashMap<>();

     public PetPayloadBuilder withId(String id) {
        PetPayLoad.put("id", id);
        return this;
     }
     public PetPayloadBuilder withName(String name) {
         PetPayLoad.put("name", name);
         return this;
     }
     public PetPayloadBuilder withPhotoUrls(String[]photoUrls) {
         PetPayLoad.put("photoUrls", photoUrls);
         return this;
     }
    public PetPayloadBuilder withStatus(String status) {
        PetPayLoad.put("status", status);
        return this;
    }

    //Implementar Tags e Categorias depois - Criar Objetos e enviar arrayType<Tag>


    public Map<String, Object> build() {
        return PetPayLoad;
    }
}
