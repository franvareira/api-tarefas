package ApiTarefas.Post;

import TestBases.UserTestBase;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postCriarUsuario extends UserTestBase {


    @Test
    public void CriarUsuario(){

        Response resposta =

                given()
                        .log().body()
                        .spec(requestSpec)
                .when()
                        .post()
                .then()
                        .log().body()
                        .spec(responseSpec)
                        .statusCode(201)
                        .extract().response();

        FileOperations.setProperties("Variables", "tokenUser", resposta.then().extract().path("data.attributes.auth-token"));
        System.out.println(resposta.then().extract().path("data.attributes.auth-token").toString());


    }

}
