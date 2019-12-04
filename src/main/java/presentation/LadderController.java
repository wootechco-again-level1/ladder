package presentation;

import domain.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.result.ResultGenerator;
import domain.result.Results;
import domain.user.Users;
import domain.user.UsersGenerator;
import utils.InputUtils;

public class LadderController {
    public static LadderGame play(final String names, final String result, final int height) {
        Users users = UsersGenerator.generate(InputUtils.parseNames(names));
        Ladder ladder = LadderGenerator.generate(users, height);
        Results results = new Results(users, ResultGenerator.generate(InputUtils.parseNames(result)));

        LadderGame ladderGame = new LadderGame(users, ladder, results);
        ladderGame.move();
        ladderGame.result();

        return ladderGame;
    }
}
