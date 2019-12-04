package domain.user.exception;

public class InvalidNameLengthException extends RuntimeException {
    private static final String MESSAGE = "이름은 5글자이하여야 합니다.";

    public InvalidNameLengthException() {
        super(MESSAGE);
    }
}
