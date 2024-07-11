package ContatosTestCases;

import Models.CriarContatoModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postCriarContatoModel {


    private static RequestSpecification requestSpec;
    private static RequestSpecification requestSpecDelete;
    private static ResponseSpecification responseSpec;
    private CriarContatoModel criarContatoModel = new CriarContatoModel();

    @BeforeEach
    public void setUp(){

            requestSpec = new RequestSpecBuilder()
                    .setBaseUri("https://api-de-tarefas.herokuapp.com")
                    .setBasePath("/contacts")
                    .setBody(criarContatoModel)
                    .setContentType(ContentType.JSON)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept","application/vnd.tasksmanager.v2")
                    .build();


            requestSpecDelete = new RequestSpecBuilder()
                .addHeader("Content-type" , "application/json")
                .addHeader("Accept", "application/vnd.taskmanager.v2")
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setContentType(ContentType.JSON)
                .build();

            responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }

    @Test
    public void criarContato(){
        String id =
                given()
                    .spec(requestSpec)
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                .and()
                    .log().body()
                    .statusCode(201)
                    .extract().path("data.id");

        System.out.println(id.toString());

        deletarContato(id);
        verificarDeletarContato(id);

    }

    private void deletarContato(String id) {
                given().
                    spec(requestSpec).
                when().
                    delete("/" + id).
                then().
                     log().ifValidationFails(LogDetail.STATUS).
                     statusCode(204);
    }

    private void verificarDeletarContato(String id) {
                 given()
                    .spec(requestSpecDelete)
                .when()
                    .get("/" + id)
                .then()
                    .spec(responseSpec)
                    .log().status()
                    .statusCode(404);
    }



}
