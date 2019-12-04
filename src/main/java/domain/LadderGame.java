package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderLine;
import domain.result.Result;
import domain.result.Results;
import domain.user.Users;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Users users;
    private Ladder ladder;
    private Results results;

    public LadderGame(final Users users, final Ladder ladder, final Results results) {
        this.users = users;
        this.ladder = ladder;
        this.results = results;
    }

    public void move() {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            users = users.move(ladderLine);
        }
    }

    public Map<String, Result> result() {
        List<String> names = users.getNames();
        List<Result> result = results.changeResults();
        List<Integer> positions = users.getPositions();

        return Collections.unmodifiableMap(IntStream.range(0, users.size())
                .boxed()
                .collect(Collectors.toMap(
                        names::get,
                        index -> result.get(positions.get(index)))
                )
        );
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "LadderGame{" + "users=" + users + ", ladder=" + ladder + '}';
    }
}
