package APItests.GetSelfPostsTests;

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

public class SearchAscPage2 extends TestClass {
    @Test
    @DisplayName("Get запрос с выводом второй страницы своих постов при сортировке в порядке возрастания")
    void getSelfPostsAscPage2() {
        List<SearchResponse> searchResponses = Arrays.asList(given()
                .queryParam("order", "ASC")
                .queryParam("page", "2")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .spec(responseSpecification)
                .extract()
                .as(SearchResponse.class));
        assertThat(searchResponses.stream().findFirst().get().getData().stream().findFirst().get().getDescription(), containsString("торт 2019"));}
}
