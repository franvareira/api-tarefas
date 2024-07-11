package ApiTarefas.Delete;

import TestBases.TarefaTestBase;
import Utils.FileOperations;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class deleteTarefa extends TarefaTestBase {

    private static final String id = FileOperations.getProperties("Variables").getProperty("idTarefa");

    @Test
    public void deletarTarefa(){

        given()
                .spec(requestSpec)
        .when()
                .delete( "/" + id)
        .then()
                .statusCode(204);

    }

    @Test
    public void verificaDeletarTarefa(){

        given()
                .spec(requestSpec)
        .when()
                .get( "/" + id)
        .then()
                .spec(responseSpec)
                .log().status()
                .statusCode(404);

    }

}
