package domain.result;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultGeneratorTest {
    @Test
    void createResultGenerator() {
        List<Result> results = ResultGenerator.generate(
                Arrays.stream("꽝,5000,꽝,5000".split(","))
                        .collect(Collectors.toList())
        );

        assertEquals(results, Arrays.asList(
                new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("5000")
        ));
    }
}
