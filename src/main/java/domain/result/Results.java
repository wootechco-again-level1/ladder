package domain.result;

import domain.result.exception.InvalidResultsSize;
import domain.user.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Results {
    private final Users users;
    private final List<Result> results;

    public Results(final Users users, final List<Result> results) {
        checkResultsSize(users, results);
        this.users = users;
        this.results = results;
    }

    private void checkResultsSize(final Users users, final List<Result> results) {
        if (users.size() != results.size()) {
            throw new InvalidResultsSize();
        }
    }

    public List<Result> changeResults() {
        List<Result> resultChange = new ArrayList<>();
        List<Integer> positions = users.getPositions();

        IntStream.range(0, results.size())
                .forEach(index -> resultChange.add(results.get(positions.get(index))));

        return resultChange;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
