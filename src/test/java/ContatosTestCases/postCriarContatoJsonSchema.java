package ContatosTestCases;

import Models.CriarContatoModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postCriarContatoJsonSchema {

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
                        .addHeader("Content-Type","application/json")
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
    public void criarContatoJsonValidator(){

        String id =
                given()
                    .spec(requestSpec)
                    .log().body()
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                    .statusCode(201)
                    .log().body()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/json-schema.json"))
                    .extract().path("data.id");

        System.out.println(id.toString());

        deletaContato(id);
        verificaDelete(id);
    }


    private void deletaContato(String id) {

                given()
                    .spec(requestSpecDelete)
                .when()
                    .delete("/" + id)
                .then()
                    .log()
                    .ifValidationFails(LogDetail.STATUS)
                    .statusCode(204);

    }

    private void verificaDelete(String id) {

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