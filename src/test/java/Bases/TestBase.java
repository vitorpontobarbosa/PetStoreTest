package Bases;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;


public class TestBase {

    public String BaseUrl = "https://petstore.swagger.io/";
    public String ProjectPath = System.getProperty("user.dir");

    public String ReadJson(String Path) throws IOException {
        return new String(readAllBytes(Paths.get(ProjectPath + "/src/test/java/Jsons/"+ Path)));
    }

}
