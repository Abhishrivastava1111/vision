package com.crack.vision.doc;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessHandler {
    private boolean success;
    private String message;
    private Object data;

    public SuccessHandler(boolean success,String message , Object data){
        this.success = success;
        this.message = message;
        this.data = data;

    }
}
