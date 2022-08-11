package refactor.shopproject.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResult<T> {

    private T result;
    private HttpStatus status;

    public ApiResult(T result) {
        this.result = result;
        this.status = HttpStatus.OK;
    }
}
