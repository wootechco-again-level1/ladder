package domain.user;

import domain.user.exception.DuplicateNameException;
import domain.user.exception.InvalidNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsersGeneratorTest {
    private static final String DELIMITER = ",";

    @Test
    @DisplayName("이름 5글자 이하 사용자 생성 성공")
    void createUsers() {
        assertDoesNotThrow(() -> {
            UsersGenerator.generate(Arrays.asList("mir, cony, ike".split(DELIMITER)));
        });
    }

    @Test
    @DisplayName("이름 5글자 초과 사용자 생성 실패")
    void failedCreateUsers1() {
        assertThrows(InvalidNameLengthException.class, () -> {
            UsersGenerator.generate(Arrays.asList("heebong, chelsea".split(DELIMITER)));
        });
    }

    @Test
    @DisplayName("이름이 중복이 경우 생성 실패")
    void failedCreateUsers2() {
        assertThrows(DuplicateNameException.class, () -> {
            UsersGenerator.generate(Arrays.asList("mir, mir, mir".split(DELIMITER)));
        });
    }
}
