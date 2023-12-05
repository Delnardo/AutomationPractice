/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pruebasrest;

import Entidades.PeliculaPojo;
import Entidades.Planeta;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.google.gson.Gson;

/**
 *
 * @author kamil
 */
public class PruebasRest {

    public static void main(String[] args) {
        // Realizar una solicitud GET a una URL
        Response responsePersona = RestAssured.get("https://swapi.dev/api/people/2/");

        // Realizar una solicitud GET a una URL de la pelicula 2
        Response pelicula = RestAssured.get("https://swapi.dev/api/films/2/");
        
        // Realizar una solicitud GET a una URL de planeta
        Response Planeta = RestAssured.get("https://swapi.dev/api/planets/4/");
        
        // Realizar una solicitud GET a una URL de la Pelicula 7
        Response pelicula7 = RestAssured.get("https://swapi.dev/api/films/7/");
        
        
        // Obtener el código de estado de la respuesta de Persona
        int statusCode = responsePersona.getStatusCode();
        System.out.println("Código de estado Persona: " + statusCode);
        
        // Obtener el código de estado de la respuesta de Pelicula7
        int statusCodeP7 = pelicula7.getStatusCode();
        System.out.println("Código de estado films 7: " + statusCodeP7);
        

        // Obtener el cuerpo de la respuesta como una cadena de texto
        String responseBody = responsePersona.getBody().asString();
        System.out.println("Cuerpo de respuesta: " + responseBody);
        

        // Obtener el cuerpo de la respuesta como una cadena de texto de la pelicula 2
        String responseBodyPeli = pelicula.getBody().asString();
        System.out.println("Cuerpo de respuesta: " + responseBodyPeli);
        
        
        // Obtener el cuerpo de la respuesta como una cadena de texto
        String responseBodyPlane = Planeta.getBody().asString();
        System.out.println("Cuerpo de respuesta: " + responseBodyPlane);

        // Imprimir el Pojo del Json 
        Gson gson = new Gson();
        PeliculaPojo pojo = gson.fromJson(responseBodyPeli, PeliculaPojo.class);

        System.out.println("Nombre del director de la Pelicula: " + pojo.director);
        
        // Imprimir el Pojo del Json Planeta
     
        Planeta pj = gson.fromJson(responseBodyPlane, Planeta.class);

        System.out.println("Este es el valor de la gravedad: " + pj.gravity + " Este es el valor del terreno "+ pj.terrain);
    }

}
