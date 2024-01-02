import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortTextTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "текст15символов", "текст16 символов"})
    public void testStringLength (String shortText){
        assertTrue(shortText.length() > 15);
    }
}
