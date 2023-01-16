package APItests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String token;
    private static String url;
    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;
    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/my.properties");
        prop.load(configFile);
        token =  prop.getProperty("token");
        url= prop.getProperty("url");

    }
    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }
    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addHeader("X-Auth-Token", getToken())
                .log(LogDetail.ALL)
                .build();
    }
    public static String getToken() {
        return token;
    }

    public static String getUrl() {
        return url;
    }
}
