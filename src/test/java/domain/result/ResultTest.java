package domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @Test
    @DisplayName("결과 값을 가진 객체 생성")
    void createResult() {
        String value = "꽝";
        Result result = new Result(value);

        assertEquals(result, new Result(value));
    }
}
