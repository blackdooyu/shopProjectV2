package refactor.shopproject.common;

import lombok.Getter;

@Getter
public class ApiResult<T> {

    private T result;

    private int status;

    public ApiResult(T result, int status) {
        this.result = result;
        this.status = status;
    }

}
