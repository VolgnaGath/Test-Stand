package APItests.GetSelfPostsTests;

import APItests.TestClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetWithoutToken extends TestClass {
    @Test
    @DisplayName("Get запрос на вывод своих постов без токена")
    void getWithoutToken() {
        JsonPath response = given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .request(Method.GET, getUrl())
                .body()
                .jsonPath();
        assertThat(response.get("message"), equalTo("Auth header required X-Auth-Token"));
    }
}
