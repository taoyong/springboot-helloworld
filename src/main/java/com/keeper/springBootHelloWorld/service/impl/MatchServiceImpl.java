package com.keeper.springBootHelloWorld.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.keeper.springBootHelloWorld.service.MatchService;
import com.keeper.springBootHelloWorld.util.CommonStringUtils;
import com.keeper.springBootHelloWorld.util.WordUltil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 13:56
 * Description:
 */
@Slf4j
@Service
public class MatchServiceImpl implements MatchService {

    private static List<String> targetKeyWords = Lists.newArrayList();

    @PostConstruct
    public void init() throws Exception{
        File file = ResourceUtils.getFile("classpath:targetKeyWords");
        InputStream inputStream = new FileInputStream(file);
        targetKeyWords = IOUtils.readLines(inputStream);
    }

    @Override
    public Set<String> getKeyWords(String fileName,InputStream inputStream) {
        Set<String> mathedKeyWords = Sets.newHashSet();

        String content = WordUltil.readWordContentwWithPath(fileName,inputStream);
        for(String key : targetKeyWords){
            if(content.indexOf(key) < 0){
                continue;
            }
            mathedKeyWords.addAll(matchTargetWords(key,content));
        }
        return mathedKeyWords;
    }

    private Set<String> matchTargetWords(String key, String content){
        String[] splitContents = splitContentByKey(key,content);

        Set<String> partMatchKeys = Sets.newHashSet();

        String pattern = key+"(.*)\\d+";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        for(String each : splitContents){
            //content分割时候,会丢key那段
            if(each.indexOf(key) < 0){
                each = key + each;
            }
            // 创建 matcher 对象
            Matcher m = r.matcher(each);
            while (m.find()){
                String fundWord =  m.group();
                partMatchKeys.add(filterOtherChars(fundWord));
            }
        }
        return partMatchKeys;
    }

    private String[] splitContentByKey(String key,String content){
        return content.split(key);
    }

    private String filterOtherChars(String fundWord){
        char[] wordsArr = fundWord.toCharArray();
        for(int i = 0; i < wordsArr.length; i++ ){
            if(CommonStringUtils.isChineseChar(wordsArr[i])){
                String fundWordAfterFilter = fundWord.substring(0,i);
                log.info("当前字符串包含中文,过滤前={},过滤后={}",fundWord,fundWordAfterFilter);
                return fundWordAfterFilter;
            }
        }
        return fundWord;
    }

    private boolean isSpecialChar(char orignalChar){
        if(CommonStringUtils.isChineseChar(orignalChar) ||  CommonStringUtils.isBlankChar(orignalChar)
                || orignalChar == '('){
            return true;
        }
        return false;
    }

}
