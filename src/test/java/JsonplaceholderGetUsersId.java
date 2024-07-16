import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class JsonplaceholderGetUsersId
{
    @Test
    public void apiGetUserId()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        Response response = given().when().get("/users/5").then().extract().response();
        String responseBody = response.getBody().asString();

        given().
                when().
                get("/users/5").
                then().
                assertThat().
                statusCode(200).
                body("username", equalTo("Kamren")).
                body("email", equalTo("Lucio_Hettinger@annie.ca")).
                body("address.street", equalTo("Skiles Walks")).
                body("address.suite", equalTo("Suite 351")).
                body("address.city", equalTo("Roscoeview")).
                body("address.zipcode", equalTo("33263")).
                body("address.geo.lat", equalTo("-31.8129")).
                body("address.geo.lng", equalTo("62.5342")).
                body("phone", equalTo("(254)954-1289")).
                body("website", equalTo("demarco.info")).
                body("company.name", equalTo("Keebler LLC")).
                body("company.catchPhrase", equalTo("User-centric fault-tolerant solution")).
                body("company.bs", equalTo("revolutionize end-to-end systems"));
    }
}
