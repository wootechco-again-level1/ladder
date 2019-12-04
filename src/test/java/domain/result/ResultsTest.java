package domain.result;

import domain.result.exception.InvalidResultsSize;
import domain.user.User;
import domain.user.Users;
import domain.user.UsersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    private List<String> result;
    private Results results;

    @BeforeEach
    void setUp() {
        result = Arrays.asList("꽝", "5000");
    }

    @Test
    @DisplayName("결과와 사용자를 가지고 있는 클래스 생성")
    void createResults() {
        results = new Results(
                UsersGenerator.generate(Arrays.asList("mir", "cony")),
                ResultGenerator.generate(result)
        );

        assertEquals(results.getResults(), ResultGenerator.generate(result));
    }

    @Test
    @DisplayName("사용자 수와 결과의 수가 일치하지 않아서 에러 발생")
    void cantCreateResults() {
        assertThrows(InvalidResultsSize.class, () -> {
            results = new Results(
                    UsersGenerator.generate(Arrays.asList("mir", "cony", "ike")),
                    ResultGenerator.generate(result)
            );
        });
    }

    @Test
    @DisplayName("결과 변화")
    void changeResults() {
        results = new Results(
                new Users(
                        Arrays.asList(
                                new User("mir", 1),
                                new User("cony", 0)
                        )
                ),
                ResultGenerator.generate(result)
        );

        assertEquals(results.changeResults().get(0), new Result("5000"));
        assertEquals(results.changeResults().get(1), new Result("꽝"));
    }
}
