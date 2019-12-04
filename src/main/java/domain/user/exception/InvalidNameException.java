package domain.user.exception;

public class InvalidNameException extends RuntimeException {
    private static final String MESSAGE = "all은 이름으로 사용할 수 없습니다.";

    public InvalidNameException() {
        super(MESSAGE);
    }
}
