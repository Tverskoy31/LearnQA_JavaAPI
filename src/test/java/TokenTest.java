
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
    @Test
    //Формируем запрос на создание задачи
    public  void tokenTest() throws InterruptedException {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = response.get("token"); // забираем токен
        int second = response.get("seconds"); // забираем секунды
        int delay = second * 1000;

        //Формируем запрос с токеном
        Map<String, String> params = new HashMap<>();
        params.put("token", token);

        Response responseWithToken = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();

        // Проверка поля "status"
        assertEquals(responseWithToken.jsonPath().get("status"), "Job is NOT ready");

        Thread.sleep(delay); //включаем задержку

        //Формируем запрос с токеном после задержки
        JsonPath responseWithTokenDelay = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        // Проверка поля "status"
        Assertions.assertEquals(responseWithTokenDelay.get("status"), "Job is ready");

        // Проверка наличия поля "result"
        Assertions.assertNotNull(responseWithTokenDelay.get("result") );
    }
}