package domain.ladder;

import domain.ladder.exception.DuplicateDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderBridgeTest {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    @Test
    @DisplayName("왼쪽으로 이동할 때 포지션 변화")
    void moveLeft() {
        LadderBridge ladderBridge = LadderBridge.of(TRUE, FALSE);

        assertEquals(ladderBridge.move(), -1);
    }

    @Test
    @DisplayName("오른쪽으로 이동할 때 포지션 변화")
    void moveRight() {
        LadderBridge ladderBridge = LadderBridge.of(FALSE, TRUE);

        assertEquals(ladderBridge.move(), 1);
    }

    @Test
    @DisplayName("아래로 이동할 때 포지션 변화")
    void moveDown() {
        LadderBridge ladderBridge = LadderBridge.of(FALSE, FALSE);

        assertEquals(ladderBridge.move(), 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("이전 라인이 오른쪽 방향을 가질 경우 다음 라인 방향 생성")
    void createNextLadderBridge1(final boolean hasDirection) {
        LadderBridge ladderBridge = LadderBridge.of(FALSE, TRUE);
        LadderBridge next = ladderBridge.next(hasDirection);

        assertEquals(next, LadderBridge.of(TRUE, FALSE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("이전 라인이 왼쪽 방향을 가질 경우 다음 라인 방향 생성")
    void createNextLadderBridge2(final boolean hasDirection) {
        LadderBridge ladderBridge = LadderBridge.of(TRUE, FALSE);
        LadderBridge next = ladderBridge.next(hasDirection);

        assertEquals(next, LadderBridge.of(FALSE, hasDirection));
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("이전 라인이 방향을 가지지 않을 경우 다음 라인 방향 생성")
    void createNextLadderBridge3(final boolean hasDirection) {
        LadderBridge ladderBridge = LadderBridge.of(FALSE, FALSE);
        LadderBridge next = ladderBridge.next(hasDirection);

        assertEquals(next, LadderBridge.of(FALSE, hasDirection));
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("첫 번째 라인일 경우 방향 생성")
    void createFirstLadderBridge(final boolean hasDirection) {
        LadderBridge ladderBridge = LadderBridge.first(hasDirection);

        assertEquals(ladderBridge, LadderBridge.of(FALSE, hasDirection));
    }

    @Test
    @DisplayName("방향을 양쪽으로 가지는 경우 에러 발생")
    void creteDuplicateLadderBridge() {
        assertThrows(DuplicateDirectionException.class, () -> {
            LadderBridge.of(true, true);
        });
    }
}
