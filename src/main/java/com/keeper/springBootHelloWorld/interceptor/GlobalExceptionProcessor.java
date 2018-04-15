package com.keeper.springBootHelloWorld.interceptor;


import com.keeper.springBootHelloWorld.dto.ResponseWrapper;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionProcessor {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseWrapper validFailHandle(HttpServletRequest req, Exception e){
        BindException bindException = (BindException)e;
        BindingResult bindingResult = bindException.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().get(0);
        return ResponseWrapper.fail(objectError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseWrapper exceptionHandle(HttpServletRequest req, Exception e){
        return ResponseWrapper.fail(e.getMessage());
    }
}
