package ApiTarefas.Post;

import TestBases.LoginTestBase;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postRealizarLogin extends LoginTestBase {


    @Test
    public void realizarLogin(){

        Response resposta =

                given()
                        .log().body()
                        .spec(requestSpec)
                .when()
                        .post()
                .then()
                        .log().body()
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().response();

        FileOperations.setProperties("Variables", "tokenLogin", resposta.then().extract().path("data.attributes.auth-token"));
        System.out.println(resposta.then().extract().path("data.attributes.auth-token").toString());


    }

}
