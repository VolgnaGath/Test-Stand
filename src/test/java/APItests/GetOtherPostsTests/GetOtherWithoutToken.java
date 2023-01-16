package APItests.GetOtherPostsTests;

import APItests.TestClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetOtherWithoutToken extends TestClass {
    @Test
    @DisplayName("Get запрос чужих постов без токена")
    @Severity(SeverityLevel.BLOCKER)
    void getOtherWithoutToken() {
        JsonPath response = given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("page", "1")
                .when()
                .request(Method.GET, getUrl())
                .body()
                .jsonPath();
        assertThat(response.get("message"), equalTo("Auth header required X-Auth-Token"));
    }
}
