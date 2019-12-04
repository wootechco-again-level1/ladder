package domain.result.exception;

public class InvalidResultsSize extends RuntimeException {
    private static final String MESSAGE = "사용자 수와 실행 결과의 수가 일치하지 않습니다.";

    public InvalidResultsSize() {
        super(MESSAGE);
    }
}
