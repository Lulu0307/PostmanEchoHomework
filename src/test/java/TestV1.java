import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestV1 {

    @Test
    public void shouldReturnText() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some text")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("some text"))
        ;
    }

    @Test
    public void shouldReturnJSON() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body("{obj:1,obj2:2}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(containsString("obj3"))
        ;
    }
}
