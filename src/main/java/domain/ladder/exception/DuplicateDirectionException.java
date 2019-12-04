package domain.ladder.exception;

public class DuplicateDirectionException extends RuntimeException {
    private static final String MESSAGE = "방향은 양쪽으로 가질 수 없습니다.";

    public DuplicateDirectionException() {
        super(MESSAGE);
    }
}
