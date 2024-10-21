package com.glossapro.glossalearn.responses;

public abstract class ResponseBase<T> {

    private T data;

    private ErrorViewModel error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorViewModel getError() {
        return error;
    }

    public void setError(ErrorViewModel error) {
        this.error = error;
    }
}
