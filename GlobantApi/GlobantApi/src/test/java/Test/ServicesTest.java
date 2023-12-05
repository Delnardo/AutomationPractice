package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import static io.restassured.RestAssured.given;

public class ServicesTest {

    // primer ejercicio
    @Test
    public void getPeopleTwo(){
        Response response;

        response = given().get("https://swapi.dev/api/people/2");

        String jsonResponse = response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(JsonPath.from(jsonResponse).getString("skin_color"), "gold");

        Assert.assertEquals(JsonPath.from(jsonResponse).getList("films").size(),6);


    }

    //segundo ejercicio
    @Test
    public void getPeopleTwoPresent(){
        //Creo la variable donde voy a almacenar la solicitud
        Response response;
        //hago la solicitud
        response = given().get("https://swapi.dev/api/people/2");
        //convierto la solicitud en un string (json)
        String jsonResponse = response.getBody().asString();

        //guando en una variable la pelicula
        String filmTwo = JsonPath.from(jsonResponse).getList("films").get(1).toString();


        //obteniendo los datos de la pelicula
        Response response2 = given().get(filmTwo);
        String jsonResponse2 = response2.getBody().asString();

        Assert.assertTrue(JsonPath.from(jsonResponse2).getList("characters").size()>1);

        Assert.assertTrue(JsonPath.from(jsonResponse2).getList("planets").size()>1);

        Assert.assertTrue(JsonPath.from(jsonResponse2).getList("starships").size()>1);

        Assert.assertTrue(JsonPath.from(jsonResponse2).getList("vehicles").size()>1);

        Assert.assertTrue(JsonPath.from(jsonResponse2).getList("species").size()>1);

        // Verificar el formato de la fecha de lanzamiento
        String releaseDate = JsonPath.from(jsonResponse2).getString("release_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
            sdf.parse(releaseDate);
            System.out.println("La fecha de lanzamiento está en el formato correcto.");
        } catch (ParseException e) {
            System.out.println("La fecha de lanzamiento no está en el formato correcto.");
        }
    }

    //tercer ejercicio

    @Test
    public void planet(){
        //Creo la variable donde voy a almacenar la solicitud
        Response response;
        //hago la solicitud
        response = given().get("https://swapi.dev/api/people/2");
        //convierto la solicitud en un string (json)
        String jsonResponse = response.getBody().asString();

        //guando en una variable la pelicula
        String filmLast = JsonPath.from(jsonResponse).getList("films").get(5).toString();

        //obteniendo los datos de la pelicula
        Response response2 = given().get(filmLast);
        String jsonResponse2 = response2.getBody().asString();

        //guando en una variable el planeta
        String primerPlaneta = JsonPath.from(jsonResponse2).getList("planets").get(0).toString();


        //obteniendo los datos del planeta
        Response response3 = given().get(primerPlaneta);
        String jsonResponse3 = response3.getBody().asString();

        Assert.assertEquals(JsonPath.from(jsonResponse3).getString("gravity"), "1 standard");

        Assert.assertEquals(JsonPath.from(jsonResponse3).getString("terrain"), "desert");
    }

    //cuarto ejercicio

    @Test
    public void verificarUrl(){

        //Creo la variable donde voy a almacenar la solicitud
        Response response;
        //hago la solicitud
        response = given().get("https://swapi.dev/api/people/2");
        //convierto la solicitud en un string (json)
        String jsonResponse = response.getBody().asString();

        //guando en una variable la pelicula
        String filmLast = JsonPath.from(jsonResponse).getList("films").get(5).toString();

        //obteniendo los datos de la pelicula
        Response response2 = given().get(filmLast);
        String jsonResponse2 = response2.getBody().asString();

        //guando en una variable el planeta
        String primerPlaneta = JsonPath.from(jsonResponse2).getList("planets").get(0).toString();


        //obteniendo los datos del planeta
        Response response3 = given().get(primerPlaneta);
        String jsonResponse3 = response3.getBody().asString();


        //url
        String url = JsonPath.from(jsonResponse3).getString("url");

        //obteniendo los datos de la pelicula
        Response response4 = given().get(url);
        String jsonResponse4 = response4.getBody().asString();

        Assert.assertEquals(jsonResponse4,jsonResponse3);


    }

    //Quinto ejercicio
    @Test
    public void filmSeven(){
        Response response;

        response =  given().get("https://swapi.dev/api/films/7");
        Assert.assertEquals(response.getStatusCode(), 404);

    }
}


