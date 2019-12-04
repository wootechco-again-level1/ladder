package domain.user;

import domain.user.exception.InvalidNameException;
import domain.user.exception.InvalidNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @ParameterizedTest
    @CsvSource(value = {"mir:0", "cony:1", "ike:2"}, delimiter = ':')
    @DisplayName("사용자 이름 5자 이하일 경우 사용자 생성")
    void checkUserNameLength1(final String name, final int position) {
        User user = new User(name, position);

        assertEquals(user, new User(name, position));
    }

    @ParameterizedTest
    @CsvSource(value = {"heebong:0", "chelsea:1"}, delimiter = ':')
    void checkUserNameLength2(final String name, final int position) {
        assertThrows(InvalidNameLengthException.class, () -> {
            new User(name, position);
        });
    }

    @Test
    @DisplayName("사용자 이름이 all일 경우 예외 처리")
    void checkExclusionName() {
        assertThrows(InvalidNameException.class, () -> {
            new User("all", 0);
        });
    }
}
