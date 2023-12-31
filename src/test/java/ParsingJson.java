import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class ParsingJson {

    @Test
    public void testParsingJson() {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        //response.prettyPrint(); для отладки
        String message = response.getString("messages[1].message");
        System.out.println("\nВторое сообщение: " + message);
    }
}