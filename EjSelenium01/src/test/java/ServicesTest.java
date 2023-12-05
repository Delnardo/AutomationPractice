import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class ServicesTest {

    @Test
    public void getExample() {

        /// Given
        Response response;
        response = given().get("https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

}
