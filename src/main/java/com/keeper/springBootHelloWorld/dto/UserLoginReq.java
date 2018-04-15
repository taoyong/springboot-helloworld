package com.keeper.springBootHelloWorld.dto;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginReq {

    @NotNull(message = "useId 不能为空")
    @Min(value = 1,message = "useId 不合法")
    private Integer userId;
}
