package TestBases;

import Models.CriarContatoModel;
import Utils.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class ContatoTestBase extends Endpoints {


     protected static RequestSpecification requestSpec;

    protected static RequestSpecification requestSpecDelete;
     protected static ResponseSpecification responseSpec;
     private static final CriarContatoModel criarContatoModel = new CriarContatoModel();

     @BeforeAll
    public static void setUp(){

         buildRequest();
         buildResponse();
         buildRequestDelete();
     }

     private static void buildRequest(){

         requestSpec = new RequestSpecBuilder()
                 .setBaseUri(BASE_URI)
                 .setBasePath(PATH_CONTACTS)
                 .setBody(criarContatoModel)
                 .setContentType(ContentType.JSON)
                 .addHeader("Content-Type", "application/json")
                 .addHeader("Accept","application/vnd.tasksmanager.v2")
                 .build();

     }

     private static void buildResponse(){

         responseSpec = new ResponseSpecBuilder()
                 .expectContentType(ContentType.JSON)
                 .build();

     }

    private static void buildRequestDelete(){

        requestSpecDelete = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_CONTACTS)
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept","application/vnd.tasksmanager.v2")
                .build();

    }





}
