package com.keeper.springBootHelloWorld.util;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 19:29
 * Description:
 */
public class CommonStringUtils {

    /**
     * 判断一个字符是否是汉字
     * PS：中文汉字的编码范围：[\u4e00-\u9fa5]
     *
     * @param c 需要判断的字符
     * @return 是汉字(true), 不是汉字(false)
     */
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

    /**
     * 判断一个字符是否是汉字
     * PS：中文汉字的编码范围：[\u4e00-\u9fa5]
     *
     * @param c 需要判断的字符
     * @return 是汉字(true), 不是汉字(false)
     */
    public static boolean isBlankChar(char c) {
        return String.valueOf(c).matches("\\s");
    }

}
