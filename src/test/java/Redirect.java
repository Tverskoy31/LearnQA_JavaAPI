import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;

public class Redirect {

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