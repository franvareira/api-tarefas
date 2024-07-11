package ApiTarefas.Delete;

import TestBases.ContatoTestBase;
import Utils.FileOperations;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteContato extends ContatoTestBase {

    private static final String id = FileOperations.getProperties("Variables").getProperty("idContato");
    @Test
    public void deletarContato(){

        given()
                .spec(requestSpecDelete)
        .when()
                .delete("/" + id)
        .then()
                .statusCode(204);

    }
    @Test
    public void confirmaDeleteContato(){

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
