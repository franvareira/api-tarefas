package ContatosTestCases;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class getListaContatoBasic {


    public class getListContacts {
        @Test
        public void listaContato(){
            String baseUri = "https://api-de-tarefas.herokuapp.com/contacts";
            given()
                    .when()
                    .get(baseUri)
                    .then()
                    .log()
                    .body()
                    .assertThat()
                    .statusCode(200);
        }
        @Test
        public void listaContato2(){
            String baseUri = "https://api-de-tarefas.herokuapp.com/contacts";
            Response resposta =
                    given()
                            .when()
                            .get(baseUri)
                            .then()
                            .log()
                            .all()
                            .assertThat()
                            .statusCode(200)
                            .extract().response();
            //resposta.body().prettyPrint();
        }
        @Test
        public void listaContato3(){
            String baseUri = "https://api-de-tarefas.herokuapp.com/contacts";
            String resposta =
                    given()
                            .when()
                            .get(baseUri)
                            .then()
                            .assertThat()
                            .statusCode(200)
                            .extract().path("data[0].id");
            System.out.println(resposta.toString());
        }
        @Test
        public void listaContato4() {
            String baseUri = "https://api-de-tarefas.herokuapp.com/contacts";
            given()
                    .when()
                    .get(baseUri)
                    .then()
                    .log()
                    .body()
                    .assertThat()
                    .statusCode(200)
                    .body("data[0].attributes.name", equalTo("Aileen"));
        }
    }
}
