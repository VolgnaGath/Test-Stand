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

public class SearchSelfPostsPage1 extends TestClass {
    @Test
    @DisplayName("Get запрос с выводом своих постов в порядке возрастания, страница 1")
    @Severity(SeverityLevel.MINOR)
    void getSelfPostsPage1() {
        List<SearchResponse> searchResponses = Arrays.asList(given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .spec(responseSpecification)
                .extract()
                .as(SearchResponse.class));
        assertThat(searchResponses.stream().findFirst().get().getData().stream().findFirst().get().getTitle(), containsString("тест торт"));
    }
}
