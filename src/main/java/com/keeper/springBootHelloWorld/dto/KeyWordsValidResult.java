package com.keeper.springBootHelloWorld.dto;

import lombok.Data;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 14:03
 * Description:
 */
@Data
public class KeyWordsValidResult {

    /**
     * 原始关键字
     */
    private String keyWord;

    /**
     * 校验结果
     */
    private boolean result;

    /**
     * 正确的关键字
     */
    private String correctKeyWord;
}
