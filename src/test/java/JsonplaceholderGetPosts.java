import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class JsonplaceholderGetPosts
{
    @Test
    public void apiGet()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given().when()
                .get("/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        List<Integer> ids = response.jsonPath().getList("id", Integer.class);

        for (int i = 0; i < ids.size() - 1; i++)
        {
            assertThat(ids.get(i), lessThanOrEqualTo(ids.get(i + 1)));
        }
    }
}
