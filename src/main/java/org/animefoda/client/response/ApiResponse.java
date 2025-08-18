package org.animefoda.client.response;

public record ApiResponse<T>(
        boolean success,
        T data,
        String message
) {
    public ApiResponse(T data){
        this(true, data, null);
    }
    public ApiResponse(boolean success, String message){
        this(success, null, message);
    }
    public ApiResponse(T data, String message){
        this(true, data, message);
    }
}
