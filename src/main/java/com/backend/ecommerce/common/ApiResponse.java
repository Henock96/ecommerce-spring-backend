package com.backend.ecommerce.common;

import java.time.LocalDateTime;

public class ApiResponse {
    private final boolean succes;
    private final String message;

    public ApiResponse(boolean succes, String message){
        this.succes = succes;
        this.message = message;
    }
    public boolean isSucces(){
        return succes;
    }

    public String getMessage(){
        return message;
    }

    public String getTimestamp(){
        return LocalDateTime.now().toString();
    }

}
