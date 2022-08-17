package refactor.shopproject.common.exception;

public enum ErrorCode {

    PASSWORD_NOT_EQUAL(403,"M001","비밀번호가 일치하지 않습니다."),
    MEMBER_NOT_FOUND(401,"M002","존재하지 않는 회원입니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
