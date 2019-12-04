package domain.ladder;

import domain.LadderGame;
import domain.result.Result;
import domain.result.ResultGenerator;
import domain.result.Results;
import domain.user.Users;
import domain.user.UsersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    @Test
    @DisplayName("사용자 결과 값 확인")
    void checkLadderResult() {
        Users users = UsersGenerator.generate(Arrays.asList("mir", "cony", "ike"));

        LadderGame ladderGame = new LadderGame(
                users,
                new Ladder(
                        Arrays.asList(new LadderLine(Arrays.asList(
                                LadderBridge.first(true),
                                LadderBridge.first(true).next(false),
                                LadderBridge.first(true).next(false).last()
                        )))
                ),
                new Results(users, ResultGenerator.generate(Arrays.asList("1", "2", "3")))
        );

        ladderGame.move();
        Map<String, Result> result = ladderGame.result();

        assertEquals(result.get("mir").getValue(), "2");
        assertEquals(result.get("cony").getValue(), "1");
        assertEquals(result.get("ike").getValue(), "3");
    }
}
