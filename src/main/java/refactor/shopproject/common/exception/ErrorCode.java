package refactor.shopproject.common.exception;

public enum ErrorCode {

    PASSWORD_NOT_EQUAL(403,"M001","비밀번호가 일치하지 않습니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
