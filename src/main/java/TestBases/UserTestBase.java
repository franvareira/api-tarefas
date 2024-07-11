package TestBases;

import Models.CriarUsuarioModel;
import Utils.Endpoints;
import Utils.ObjectUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class UserTestBase extends Endpoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static final CriarUsuarioModel criarUsuarioModel = new CriarUsuarioModel();
    protected static Map<String , Object> createUserObject;

    @BeforeAll
    public static void setUp(){

        buildRequest();
        buildResponse();


    }

    private static void buildRequest(){

        createUserObject = ObjectUtils.buildModelBody("user", new CriarUsuarioModel());
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USERS)
                .setBody(createUserObject)
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/vnd.taskmanager.v2")
                .build();

    }

    private static void buildResponse(){

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}
