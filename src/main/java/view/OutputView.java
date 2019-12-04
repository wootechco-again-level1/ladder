package view;

import domain.ladder.Ladder;
import domain.result.Result;
import domain.result.Results;
import domain.user.User;
import domain.user.Users;

import java.util.Map;

public class OutputView {
    private static final String LINE = "|";
    private static final String USER_LENGTH_SIZE = "%-6s";
    private static final String DASH = "-----";
    private static final String BLANK = "     ";
    private static final String NEW_LINE = "\n";

    public static void printUsers(final Users users) {
        for (User user : users.getUsers()) {
            System.out.printf(USER_LENGTH_SIZE, user.getName());
        }
        System.out.print(NEW_LINE);
    }

    public static void printLadder(final Ladder ladder) {
        for (int height = 0; height < ladder.height(); height++) {
            printLine(ladder, height);
            System.out.println(LINE);
        }
    }

    private static void printLine(final Ladder ladder, final int height) {
        for (int width = 0; width < ladder.width() - 1; width++) {
            System.out.print(OutputView.LINE);
            System.out.print(printLadderBridge(ladder.canMoveRight(height, width)));
        }
    }

    private static String printLadderBridge(final boolean hasRight) {
        if (hasRight) {
            return DASH;
        }

        return BLANK;
    }

    public static void printResults(final Results results) {
        for (Result result : results.getResults()) {
            System.out.format(USER_LENGTH_SIZE, result.getValue());
        }
        System.out.print(NEW_LINE);
    }

    public static void outputResult(final String name, final Map<String, Result> result) {
        System.out.println("실행 결과");

        if (result.containsKey(name)) {
            System.out.println(result.get(name).getValue());
            return;
        }

        if (User.ALL.equals(name)) {
            outputResultAll(result);
            return;
        }

        System.out.println("존재하지 않습니다.");
    }

    private static void outputResultAll(final Map<String, Result> result) {
        result.forEach((key, value) -> System.out.println(key + " : " + value.getValue()));
    }
}
