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

public class SearchOther extends TestClass {
    @Test
    @DisplayName("Get запрос чужих постов")
    void getOther() {
        List<SearchResponse> searchResponses = Arrays.asList(given()
                .queryParam("owner", "notMe")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .spec(requestSpecification)
                .when()
                .request(Method.GET, getUrl())
                .then()
                .spec(responseSpecification)
                .extract()
                .as(SearchResponse.class));
        assertThat(searchResponses.stream().findFirst().get().getData().stream().findFirst().get().getTitle(), containsString("жареные сосиски"));
    }
}
