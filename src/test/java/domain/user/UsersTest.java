package domain.user;

import domain.ladder.LadderBridge;
import domain.ladder.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {

    @Test
    @DisplayName("사용자 이동")
    void moveUsers() {
        Users users = new Users(
                Arrays.asList(
                        new User("mir", 0),
                        new User("cony", 1),
                        new User("ike", 2)
                )
        );

        List<LadderBridge> ladderBridges = new ArrayList<>();

        LadderBridge first = LadderBridge.first(false);
        LadderBridge next = first.next(true);

        ladderBridges.add(first);
        ladderBridges.add(next);
        ladderBridges.add(next.last());

        LadderLine ladderLine = new LadderLine(ladderBridges);

        Users movedUsers = users.move(ladderLine);

        assertEquals(movedUsers.getUsers().get(0), new User("mir", 0));
        assertEquals(movedUsers.getUsers().get(1), new User("cony", 2));
        assertEquals(movedUsers.getUsers().get(2), new User("ike", 1));
    }
}
