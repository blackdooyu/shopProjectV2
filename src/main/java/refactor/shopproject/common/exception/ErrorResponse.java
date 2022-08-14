package refactor.shopproject.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String message;

    private int status;

    private String code;

    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
    }

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
        this.status = HttpStatus.BAD_REQUEST.value();
    }

    public static List<ErrorResponse> fieldErrors(BindingResult bindingResult) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            ErrorResponse errorResponse = new ErrorResponse(allError.getDefaultMessage(), allError.getCode());
            errorResponses.add(errorResponse);
        }
        return errorResponses;
    }


}
