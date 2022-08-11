package refactor.shopproject.common.exception;

public class PasswordNotEqualException extends TotalErrorResponse{

    public PasswordNotEqualException() {
        super(ErrorCode.PASSWORD_NOT_EQUAL);
    }
}
