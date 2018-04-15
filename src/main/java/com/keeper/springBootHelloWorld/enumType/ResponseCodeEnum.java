package com.keeper.springBootHelloWorld.enumType;

import lombok.Getter;

public enum ResponseCodeEnum {

    SUCC("0000","成功"),
    FAIL("4000","失败");

    @Getter
    private String code;

    @Getter
    private String desc;

    ResponseCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
