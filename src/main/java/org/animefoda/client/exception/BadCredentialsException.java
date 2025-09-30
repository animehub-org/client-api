package org.animefoda.client.exception;

public class BadCredentialsException extends BaseError {
    public BadCredentialsException() {
        super("Invalid email or password", ErrorCode.VALIDATION_ERROR);
    }
}
