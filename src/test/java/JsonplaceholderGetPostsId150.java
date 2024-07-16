import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonplaceholderGetPostsId150
{
    @Test
    public void apiGet150()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().when()
                .get("/posts/150")
                .then()
                .assertThat()
                .statusCode(404)
                .body("body", isEmptyOrNullString());
    }
}
