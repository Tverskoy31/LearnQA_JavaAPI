import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SmallRedirectTest {

    @Test
    public void testRedirectSmall() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String LocationHeader = response.getHeader("Location");
        System.out.println("\nСсылка куда идёт редирект: " + LocationHeader);
    }
}