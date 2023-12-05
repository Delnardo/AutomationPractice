import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;



public class TestServices {

    @Test
    public void pushExample() {

        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("name","Fulanito");
        user.put("lastname","Perez");
        user.put("age","12");

        response = given().contentType("aplication/json").body(user).when().post("https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users");

        Assert.assertEquals(response.getStatusCode(),201);


    }
}
