package com.keeper.springBootHelloWorld.dto;

import com.keeper.springBootHelloWorld.enumType.ResponseCodeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class ResponseWrapper<T> {

    private String code;

    private String msg;

    private T data;

    public static ResponseWrapper succ(){

        return ResponseWrapper.builder().code(ResponseCodeEnum.SUCC.getCode()).msg(ResponseCodeEnum.SUCC.getDesc()).build();
    }

    public static ResponseWrapper fail(){

        return ResponseWrapper.builder().code(ResponseCodeEnum.FAIL.getCode()).msg(ResponseCodeEnum.FAIL.getDesc()).build();
    }

    public static ResponseWrapper fail(String msg){

        return ResponseWrapper.builder().code(ResponseCodeEnum.FAIL.getCode()).msg(msg).build();
    }
}
