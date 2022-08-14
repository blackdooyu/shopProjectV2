package refactor.shopproject.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(PasswordNotEqualException.class)
    public ResponseEntity<ErrorResponse> passwordNotEqualException(PasswordNotEqualException e) {
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        log.error("passwordNotEqualException : {}",response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorResponse> errorResponses = ErrorResponse.fieldErrors(e.getBindingResult());
        log.error("passwordNotEqualException : {}",errorResponses);
        return new ResponseEntity<>(errorResponses, HttpStatus.BAD_REQUEST);
    }
}
