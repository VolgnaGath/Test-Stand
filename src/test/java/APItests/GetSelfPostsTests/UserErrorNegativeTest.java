package APItests.GetSelfPostsTests;

import APItests.SearchResponse;
import APItests.TestClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserErrorNegativeTest extends TestClass {
    @Test
    @DisplayName("Get запрос своих постов с ошибкой пользователя")
    @Severity(SeverityLevel.TRIVIAL)
    void getUserErrorNegativeTest() {
        given()
                .queryParam("order", "asd")
                .queryParam("page", "1")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .statusCode(400);}
}
