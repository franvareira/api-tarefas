package TestBases;

import Models.CriarTarefaModel;
import Utils.Endpoints;
import Utils.FileOperations;
import Utils.ObjectUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class TarefaTestBase extends Endpoints {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static final CriarTarefaModel criarTarefaModel = new CriarTarefaModel();
    protected static Map<String, Object> criarTarefaObject;

    @BeforeAll
    public static void setUp(){

        buildRequest();
        buildResponse();

    }

    private static void buildRequest(){

        String token = FileOperations.getProperties("Variables").getProperty("tokenLogin");
        criarTarefaObject = ObjectUtils.buildModelBody("task",criarTarefaModel);
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_TASKS)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();

    }

    private static void buildResponse(){

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }


}
