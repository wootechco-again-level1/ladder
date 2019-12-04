package domain.user;

import domain.user.exception.DuplicateNameException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UsersGenerator {
    private static final int INIT_POSITION = 0;

    public static Users generate(final List<String> names) {
        checkDuplicateName(names);

        return new Users(IntStream.range(INIT_POSITION, names.size())
                .mapToObj(index -> new User(names.get(index), index))
                .collect(Collectors.toList())
        );
    }

    private static void checkDuplicateName(final List<String> names) {
        int count = (int) names.stream()
                .distinct()
                .count();

        if (count != names.size()) {
            throw new DuplicateNameException();
        }
    }
}
