package org.animefoda.client.exception;

public class NotFound extends BaseError{
    public NotFound(String message) {
        super(message, ErrorCode.NOT_FOUND);
    }
}
