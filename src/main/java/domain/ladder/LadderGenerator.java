package domain.ladder;

import domain.user.Users;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    public static Ladder generate(final Users users, int height) {
        return new Ladder(
                Collections.unmodifiableList(IntStream.range(0, height)
                        .mapToObj(index -> LadderLineGenerator.generate(users))
                        .collect(Collectors.toList())
        ));
    }
}
