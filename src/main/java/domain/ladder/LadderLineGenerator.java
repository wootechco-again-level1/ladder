package domain.ladder;

import domain.user.Users;

public class LadderLineGenerator {
    public static LadderLine generate(final Users users) {
        return new LadderLine(LadderBridgeGenerator.generate(users));
    }
}
