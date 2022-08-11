package refactor.shopproject.common.exception;

import lombok.Getter;

@Getter
public class TotalException extends RuntimeException{

    private ErrorCode errorCode;

    public TotalException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
