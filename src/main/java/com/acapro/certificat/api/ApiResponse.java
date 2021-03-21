package com.acapro.certificat.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private int status;
    private T data;

    public ApiResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }



    public ApiResponse(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }


    public ApiResponse(String message){
        this.message= message;

    }

}