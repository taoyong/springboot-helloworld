package com.keeper.springBootHelloWorld.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.keeper.springBootHelloWorld.dto.KeyWordsValidResult;
import com.keeper.springBootHelloWorld.dto.ResponseWrapper;
import com.keeper.springBootHelloWorld.dto.UserLoginReq;

import com.keeper.springBootHelloWorld.service.KeyWordsValidService;
import com.keeper.springBootHelloWorld.service.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/helloworld/app/v1")
public class AppController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private KeyWordsValidService keyWordsValidService;

    /**
     * local-requrl:http://localhost:8080/helloworld/app/v1/userlogin?userId=333
     * @param userLoginReq
     * @return
     */
    @RequestMapping("/userlogin")
    public ResponseWrapper userLogin(@Valid UserLoginReq userLoginReq){
        log.info("用户登录,userLoginReq={}",userLoginReq);
        return ResponseWrapper.succ();
    }

    /**
     * local-requrl:http://localhost:8080/helloworld/app/v1/greeting
     * @return
     */
    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("index");
        mv.addObject("title","欢迎来到我的个人空间!");
        return mv;
    }


    @PostMapping("/upload")
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {


        Set<String> keyWords = Sets.newHashSet();
        try {
            //匹配出关键字
            keyWords = matchService.getKeyWords(file.getOriginalFilename(),file.getInputStream());
            log.info("命中的关键字列表，keyWords={}",JSON.toJSONString(keyWords));

            List<KeyWordsValidResult> keyWordsValidResults = keyWordsValidService.keyWordVaildAndCorrect(keyWords);
            log.info("content={}","");
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadStatus");

        modelAndView.addObject("fileName",file.getOriginalFilename());
        modelAndView.addObject("key",keyWords);

        return modelAndView;
    }

}

