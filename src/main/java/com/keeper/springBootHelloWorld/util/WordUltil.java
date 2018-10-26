package com.keeper.springBootHelloWorld.util;

import com.google.common.collect.Lists;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 13:37
 * Description:
 */
public class WordUltil {

    public static String readWordContentwWithPath(String path) {

        String buffer = "";
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static String readWordContentwWithPath(String endWith,InputStream is) {

        String buffer = "";
        try {
            if (endWith.endsWith(".doc")) {
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (endWith.endsWith("docx")) {
                XWPFDocument xdoc = new XWPFDocument(is);
                XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static List<String> matchTargetWords(String key, String content){
        List<String> partMatchKeys = Lists.newArrayList();

        //String pattern = key+"((.*))\\d+";
        String pattern = key+"(?!)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(content);

        while (m.find()){
            String str = m.group();
            System.out.println("str="+str);
            partMatchKeys.add(str);
        }

        return partMatchKeys;
    }

    public static void main(String[] args) {
      /*  String content = readWordContentwWithPath("/Users/enniu1/Downloads/谷歌下载目录/试用上传文件.doc");
        System.out.println(content);
*/
      /*  String key = "GB";
        String content = "GB/T20257.3-2006  hahah,中文,123    GB/T20257.3-2006";
        matchTargetWords(key,content);*/
        String str = "SL/T188-96\t堤防工程地质勘察报告规程\t1997-05-01";

        for(char c : str.toCharArray()){
            if(CommonStringUtils.isBlankChar(c)){
                System.out.println("空白字符:"+c );
            }
            if(CommonStringUtils.isChineseChar(c)){
                System.out.println("中文字符:"+c);
            }
        }
    }
}
