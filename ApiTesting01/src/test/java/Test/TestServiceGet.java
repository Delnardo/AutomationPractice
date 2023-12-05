package Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestServiceGet {

    private int userId;

    @Test(priority = 1)
    public void getExample() {

        Response response;
        response = given().get("http://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dependsOnMethods = "getExample")
    public void postExample() {

        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("name", "Brenda"); //-->Tu Nombre
        user.put("lastname", "Calzada"); //-->Tu Apellido
        user.put("age", "35"); //-->Tu Edad

        response = given().contentType("application/JSON").body(user).when().post(
                "https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users");


        Assert.assertEquals(response.getStatusCode(), 201);

        String jsonResponse = response.getBody().asString();
        userId = JsonPath.from(jsonResponse).getInt("id");

    }

    @Test(priority = 3, dependsOnMethods = "postExample")
    public void putExample() {

        Response response;
        response = given().get("http://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/");
        String jsonResponse = response.getBody().asString();

        Map<String, String> user = new HashMap<>();
        user.put("name", "Brendaaaa"); //-->Tu Nombre
        user.put("lastname", "Calza"); //-->Tu Apellido
        user.put("age", "30"); //-->Tu Edad

        response = given().contentType("application/JSON").body(user).when().put(
                "https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void delExample() {

        Response response;
        response = given().get("http://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/");
        String jsonResponse = response.getBody().asString();

        response = given().contentType("application/JSON").delete(
                "https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 200);

    }

}
