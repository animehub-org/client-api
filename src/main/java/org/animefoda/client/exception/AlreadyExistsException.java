package org.animefoda.client.exception;

public class AlreadyExistsException extends BaseError {
    public AlreadyExistsException(String type) {
        super(type+ " already exists ", ErrorCode.EXISTS);
    }
}
