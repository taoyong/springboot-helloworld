package com.keeper.springBootHelloWorld.service;

import com.keeper.springBootHelloWorld.dto.KeyWordsValidResult;

import java.util.List;
import java.util.Set;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 14:01
 * Description: 关键字校验
 */
public interface KeyWordsValidService {


    List<KeyWordsValidResult> keyWordVaildAndCorrect(Set<String> keyWords);
}
