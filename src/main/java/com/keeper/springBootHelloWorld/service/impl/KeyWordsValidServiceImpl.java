package com.keeper.springBootHelloWorld.service.impl;

import com.google.common.collect.Lists;
import com.keeper.springBootHelloWorld.dto.KeyWordsValidResult;
import com.keeper.springBootHelloWorld.service.KeyWordsValidService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 14:02
 * Description: 关键字校验服务
 */

@Service
public class KeyWordsValidServiceImpl implements KeyWordsValidService {


    @Override
    public List<KeyWordsValidResult> keyWordVaildAndCorrect(Set<String> keyWords) {
        //

        return null;
    }
}
