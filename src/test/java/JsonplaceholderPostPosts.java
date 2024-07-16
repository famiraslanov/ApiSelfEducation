import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonplaceholderPostPosts
{
    @Test
    public void apiPost()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"title\": \"AlexExample\",\n" +
                "  \"body\": \"example_body\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .assertThat()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("AlexExample"))
                .body("body", equalTo("example_body"));
    }
}
