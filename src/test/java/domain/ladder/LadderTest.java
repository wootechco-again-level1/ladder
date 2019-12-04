package domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ladderLines.add(new LadderLine(
                    Arrays.asList(
                            LadderBridge.first(true),
                            LadderBridge.first(true).next(false)
                    )
            ));
        }

        ladder = new Ladder(ladderLines);
    }

    @Test
    @DisplayName("사다리 다리 확인 ex) |-----|     |")
    void checkLadderWidth() {
        assertEquals(ladder.width(), 2);
    }

    @Test
    @DisplayName("사다리 높이 확인")
    void checkLadderHeight() {
        assertEquals(ladder.height(), 5);

    }

    @Test
    @DisplayName("사다리 오른쪽으로 이동할 수 있음")
    void canMoveRight() {
        assertTrue(ladder.canMoveRight(0, 0));
    }

    @Test
    @DisplayName("사다리 오른쪽으로 이동할 수 없음")
    void cantMoveRight() {
        assertFalse(ladder.canMoveRight(0, 1));
    }
}