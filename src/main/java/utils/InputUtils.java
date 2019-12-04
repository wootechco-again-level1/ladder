package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    private static final String DELIMITER = ",";

    public static List<String> parseNames(final String names) {
        return Collections.unmodifiableList(
                Arrays.stream(names.split(DELIMITER))
                        .collect(Collectors.toList())
        );
    }
}
