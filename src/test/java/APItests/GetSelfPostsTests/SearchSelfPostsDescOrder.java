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

public class SearchSelfPostsDescOrder extends TestClass {
    @Test
    @DisplayName("Get запрос с выводом всех своих постов в порядке убывания")
    @Severity(SeverityLevel.MINOR)
    void getSelfPostsDescOrder() {
    List<SearchResponse> searchResponses = Arrays.asList(given()
            .queryParam("order", "DESC")
            .spec(requestSpecification)
            .when()
            .request(Method.GET, getUrl())
            .then()
            .spec(responseSpecification)
            .extract()
            .as(SearchResponse.class));
    assertThat(searchResponses.stream().findFirst().get().getData().stream().findFirst().get().getDescription(), containsString("Описание тест"));}

}
