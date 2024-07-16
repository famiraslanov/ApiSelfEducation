import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonplaceholderGetPostsId
{
    @Test
    public void apiGetId()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().when()
                .get("/posts/99")
                .then()
                .assertThat()
                .statusCode(200)
                .body("userId", equalTo(10))
                .body("id", equalTo(99))
                .body("title", not(isEmptyOrNullString()))
                .body("body", not(isEmptyOrNullString()));
    }
}
