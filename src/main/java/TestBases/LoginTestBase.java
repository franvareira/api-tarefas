package TestBases;

import Models.RealizarLoginModel;
import Utils.Endpoints;
import Utils.ObjectUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class LoginTestBase extends Endpoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static final RealizarLoginModel realizarLoginModel = new RealizarLoginModel();


    @BeforeAll
    public static void setUp(){

        buildRequest();
        buildResponse();


    }

    protected static void buildRequest(){

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_SESSIONS)
                .setBody(realizarLoginModel)
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/vnd.taskmanager.v2")
                .build();
    }

    protected static void buildResponse(){

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }

}
