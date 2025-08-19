package org.animefoda.client.response;

import org.animefoda.client.exception.ErrorCode;

import java.time.Instant;

public record ApiResponse<T>(
        boolean success,
        T data,
        String message,
        Instant timestamp,
        String errorCode
) {
    public ApiResponse(T data){
        this(true, data, null, Instant.now(), null);
    }
    public ApiResponse(boolean success, String message){
        this(success, null, message, Instant.now(), null);
    }
    public ApiResponse(T data, String message){
        this(true, data, message, Instant.now(), null);
    }
    public ApiResponse(String message, String errorCode){
        this(false, null, message, Instant.now(), errorCode);
    }

    public static <T> ApiResponse<T> error(String message, ErrorCode errorCode){
        return new ApiResponse<>(message, errorCode.name());
    }

    public static <T> ApiResponse<T> success(T data, String message){
        return new ApiResponse<>(data, message);
    }
}
