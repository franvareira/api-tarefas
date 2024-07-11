package ContatosTestCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postCriarContatoMap {

    private static RequestSpecification requestSpec;

    private static RequestSpecification requestSpecDelete;
    private static ResponseSpecification  responseSpec;


    @BeforeEach
    public void setUp(){

        Map <String , Object> requestBody = new HashMap<>();

        requestBody.put("name", "Automacao");
        requestBody.put("last_name","API");
        requestBody.put("email","novoemailapi@teste.com.br");
        requestBody.put("age","34");
        requestBody.put("phone","123456789");
        requestBody.put("address","Rua da DB");
        requestBody.put("state","Rio Grande do sul");
        requestBody.put("city","Porto Alegre");

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setBody(requestBody)
                .setContentType(ContentType.JSON)
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/vnd.taskmanager.v2")
                .build();

        requestSpecDelete = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setContentType(ContentType.JSON)
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/vnd.taskmanager.v2")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();


    }

    @Test
    public void criarContato(){

                given()
                        .spec(requestSpec)
                .when()
                        .post()
                .then()
                        .spec(responseSpec)
                .and()
                        .log()
                        .body()
                        .statusCode(201);

    }


    @Test
    public void criaEsalvaId(){

        String id =

                given()
                        .spec(requestSpec)
                .when()
                        .post()
                .then()
                        .spec(responseSpec)
                .and()
                        .log()
                        .body()
                        .statusCode(201)
                        .extract().path("data.id");

        System.out.println(id.toString());
        deletarContato(id);
        verificarDeletarContato(id);

    }

    private void deletarContato(String id){

        given()
                .spec(requestSpecDelete)
        .when()
                .delete("/" + id)
       .then()
                .log()
                .ifValidationFails(LogDetail.STATUS)
                .statusCode(204);
    }

    private void verificarDeletarContato(String id){

        given()
                .spec(requestSpecDelete)
        .when()
                .get("/" + id)
        .then()
                .spec(responseSpec)
                .log()
                .status()
                .statusCode(404)
                .body("error", equalTo("Not Found"));

    }


}
