package APItests.GetOtherPostsTests;

import APItests.TestClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchOtherOrderAll extends TestClass {
    @Test
    @DisplayName("Get запрос с выводом всех чужих постов в рандомном порядке")
    @Severity(SeverityLevel.MINOR)
    void getOtherOrderAll() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ALL")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .spec(responseSpecification);
    }
}
