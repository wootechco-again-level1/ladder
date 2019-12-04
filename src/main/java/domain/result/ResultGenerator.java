package domain.result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultGenerator {
    public static List<Result> generate(final List<String> results) {
        return Collections.unmodifiableList(results.stream()
                .map(Result::new)
                .collect(Collectors.toList())
        );
    }
}
