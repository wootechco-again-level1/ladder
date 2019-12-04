package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderLineTest {

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("오른쪽으로 이동할 수 있는지 확인")
    void checkRightDirection(final boolean movableRight) {
        List<LadderBridge> ladderBridges = new ArrayList<>();
        ladderBridges.add(LadderBridge.first(movableRight));
        LadderLine ladderLine = new LadderLine(ladderBridges);

        assertEquals(ladderLine.canMoveRight(0), movableRight);
    }

    @Test
    @DisplayName("사다리 사이즈 확인")
    void checkLadderWidthSize() {
        List<LadderBridge> ladderBridges = new ArrayList<>();

        ladderBridges.add(LadderBridge.first(true));
        ladderBridges.add(ladderBridges.get(0).next(true));

        LadderLine ladderLine = new LadderLine(ladderBridges);

        assertEquals(2, ladderLine.width());
    }
}