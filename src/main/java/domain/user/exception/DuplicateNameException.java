package domain.user.exception;

public class DuplicateNameException extends RuntimeException {
    private static final String MESSAGE = "사용자 이름을 중복될 수 없습니다.";

    public DuplicateNameException() {
        super(MESSAGE);
    }
}
