package APItests.GetOtherPostsTests;

import APItests.SearchResponse;
import APItests.TestClass;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchOtherCratedAt extends TestClass {
    @Test
    @DisplayName("Get запрос чужих постов, сортировка по дате")
    void getOtherCratedAt() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .spec(responseSpecification);
    }

}
