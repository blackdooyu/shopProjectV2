package refactor.shopproject.common.exception;

public class PasswordNotEqualException extends TotalException {

    public PasswordNotEqualException() {
        super(ErrorCode.PASSWORD_NOT_EQUAL);
    }
}
