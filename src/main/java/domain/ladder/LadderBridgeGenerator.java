package domain.ladder;

import domain.user.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderBridgeGenerator {
    private static final Random random = new Random();

    public static List<LadderBridge> generate(final Users users) {
        List<LadderBridge> ladderBridges = new ArrayList<>();

        ladderBridges.add(LadderBridge.first(random.nextBoolean()));

        for (int i = 0; i < users.size() - 2; i++) {
            ladderBridges.add(ladderBridges.get(i).next(random.nextBoolean()));
        }

        ladderBridges.add(ladderBridges.get(users.size() - 2).last());

        return Collections.unmodifiableList(ladderBridges);
    }
}
