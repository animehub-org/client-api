package org.animefoda.client.exception;

public class BaseError extends RuntimeException {
    protected final ErrorCode errorCode;
    public BaseError(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
