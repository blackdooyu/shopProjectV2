package refactor.shopproject.common;

import org.springframework.http.HttpStatus;

public class ApiResult<T> {

    private T result;
    private HttpStatus status;

    public ApiResult(T result) {
        this.result = result;
        this.status = HttpStatus.OK;
    }
}
