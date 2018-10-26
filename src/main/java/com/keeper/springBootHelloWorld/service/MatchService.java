package com.keeper.springBootHelloWorld.service;

import java.io.InputStream;
import java.util.Set;

/**
 * Created with:IntelliJ IDEA.
 * Created by: taoyong
 * Time: 2018-10-25 13:56
 * Description:
 */
public interface MatchService {

    Set<String> getKeyWords(String filename, InputStream inputStream);
}
