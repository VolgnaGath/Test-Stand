package APItests.LoginTests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class InvalidLogin extends LoginTestClass{
    @Test
    @DisplayName("Post для входа с невалидным логином")
    @Severity(SeverityLevel.BLOCKER)
    void validLogin() {
        JsonPath response = given()
                .formParam("username", "12344444444//..%$")
                .formParam("password", "fa4d864631")
                .spec(requestSpecification)
                .when()
                .request(Method.POST, getLoginUrl())
                .body()
                .jsonPath();
        assertThat(response.get("error"), equalTo("Invalid credentials."));
    }
}
