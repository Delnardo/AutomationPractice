package Test;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class TestService {

    @Test
    public void pushExample() {

        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("name","Pablo");
        user.put("lastname","Mendez");
        user.put("age","12");

        response = given().contentType("application/json").body(user).when().post("https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users");

        Assert.assertEquals(response.getStatusCode(),201);

    }
}
