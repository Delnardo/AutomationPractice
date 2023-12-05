package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.EmployeePojo;

import java.util.HashMap;
import java.util.Map;

public class testMockApi {


    @Test
    public static void main(String[] args) {
        String apiUrl = "https://654433205a0b4b04436c2233.mockapi.io/practice/v1/Users/12";

        // Realizar una solicitud GET a la API
        Response response = RestAssured.given()
                .contentType("application/json")
                .when()
                .get(apiUrl);

        // Verificar el código de estado de la respuesta
        int statusCode = response.getStatusCode();

        if (statusCode == 200) {
            // Deserializar la respuesta JSON en un objeto EmployeePojo
            EmployeePojo userApi = response.as(EmployeePojo.class);

            // Puedes acceder a los campos del objeto EmployeePojo
            System.out.println("Nombre: " + userApi.getName());
            System.out.println("Apellido: " + userApi.getLastname());
            System.out.println("Edad: " + userApi.getAge());
        } else {
            System.out.println("La solicitud no se completó con éxito. Código de estado: " + statusCode);
        }
    }
}
