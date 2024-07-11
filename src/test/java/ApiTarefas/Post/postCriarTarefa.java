package ApiTarefas.Post;

import ApiTarefas.Delete.deleteTarefa;
import TestBases.TarefaTestBase;
import TestBases.UserTestBase;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postCriarTarefa extends TarefaTestBase {

    private static final deleteTarefa deleteTarefa = new deleteTarefa();
    @Test
    public void CriarTarefa(){

        Response resposta =

                given()
                        .spec(requestSpec)
                        .body(criarTarefaObject)
                        .log().body()
                .when()
                        .post()
                .then()
                        .log().body()
                        .spec(responseSpec)
                        .statusCode(201)
                        .extract().response();

        FileOperations.setProperties("Variables", "idTarefa", resposta.then().extract().path("data.id"));

        System.out.println(resposta.then().extract().path("data.id").toString());

        deleteTarefa.deletarTarefa();
        deleteTarefa.verificaDeletarTarefa();

    }

}
