import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortTextTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "текст15символов", "текст16 символов"})
    public void testStringLength (String shortText){
        Map<String, String> longer = new HashMap<>();
        longer.put("", shortText);
        assertTrue(shortText.length() > 15);
    }
}
