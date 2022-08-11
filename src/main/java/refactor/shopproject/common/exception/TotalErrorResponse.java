package refactor.shopproject.common.exception;

public class TotalErrorResponse extends RuntimeException{

    private ErrorCode errorCode;

    public TotalErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
