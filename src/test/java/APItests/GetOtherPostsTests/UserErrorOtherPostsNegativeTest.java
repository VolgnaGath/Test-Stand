package APItests.GetOtherPostsTests;

import APItests.TestClass;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserErrorOtherPostsNegativeTest extends TestClass {
    @Test
    @DisplayName("Get запрос чужих постов с ошибкой пользователя")
    void getUserErrorOtherPosts() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("page", "11111111111111111111111111111111111111111111111111111")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .statusCode(400);}
}
