package ApiTarefas.Post;

import ApiTarefas.Delete.deleteContato;
import TestBases.ContatoTestBase;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postCriarContato extends ContatoTestBase {

    private static final deleteContato deleteContato = new deleteContato();
    @Test
    public void criarContatoBase(){

        Response payload =

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

        FileOperations.setProperties("Variables","idContato", payload.then().extract().path("data.id"));

        deleteContato.deletarContato();
        deleteContato.confirmaDeleteContato();

    }

}
