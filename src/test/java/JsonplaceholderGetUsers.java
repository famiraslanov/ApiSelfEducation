import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class JsonplaceholderGetUsers
{
    @Test
    public void apiGetUsers()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().
                when().
                get("/users").
                then().
                assertThat().
                statusCode(200).
                body("find { it.name == 'Chelsey Dietrich' }.username", equalTo("Kamren")).
                body("find { it.name == 'Chelsey Dietrich' }.email", equalTo("Lucio_Hettinger@annie.ca")).
                body("find { it.name == 'Chelsey Dietrich' }.address.street", equalTo("Skiles Walks")).
                body("find { it.name == 'Chelsey Dietrich' }.address.suite", equalTo("Suite 351")).
                body("find { it.name == 'Chelsey Dietrich' }.address.city", equalTo("Roscoeview")).
                body("find { it.name == 'Chelsey Dietrich' }.address.zipcode", equalTo("33263")).
                body("find { it.name == 'Chelsey Dietrich' }.address.geo.lat", equalTo("-31.8129")).
                body("find { it.name == 'Chelsey Dietrich' }.address.geo.lng", equalTo("62.5342")).
                body("find { it.name == 'Chelsey Dietrich' }.phone", equalTo("(254)954-1289")).
                body("find { it.name == 'Chelsey Dietrich' }.website", equalTo("demarco.info")).
                body("find { it.name == 'Chelsey Dietrich' }.company.name", equalTo("Keebler LLC")).
                body("find { it.name == 'Chelsey Dietrich' }.company.catchPhrase", equalTo("User-centric fault-tolerant solution")).
                body("find { it.name == 'Chelsey Dietrich' }.company.bs", equalTo("revolutionize end-to-end systems"));
    }
}
