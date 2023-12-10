import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RedirectTest {

    @Test
    public void testRestAssured() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        //response.prettyPrint();
        String LocationHeader = response.getHeader("Location");
        System.out.println("\nСсылка куда идёт редирект: " + LocationHeader);
    }
}