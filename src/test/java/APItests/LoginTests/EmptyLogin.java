package APItests.LoginTests;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmptyLogin extends LoginTestClass{
    @Test
    @DisplayName("Post для входа с пустым логином")
    void emptyLogin() {
        JsonPath response = given()
                .formParam("username", " ")
                .formParam("password", " ")
                .spec(requestSpecification)
                .when()
                .request(Method.POST, getLoginUrl())
                .body()
                .jsonPath();
        assertThat(response.get("error"), equalTo("Invalid credentials."));
    }
}
