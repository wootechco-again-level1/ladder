package domain.ladder.exception;

public class InvalidLadderHeightException extends RuntimeException {
    private static final String MESSAGE = "사다리 높이는 1미만일 수 없습니다.";

    public InvalidLadderHeightException() {
        super(MESSAGE);
    }
}
