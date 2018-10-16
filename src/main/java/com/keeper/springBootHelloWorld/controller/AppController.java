package com.keeper.springBootHelloWorld.controller;


import com.keeper.springBootHelloWorld.dto.ResponseWrapper;
import com.keeper.springBootHelloWorld.dto.UserLoginReq;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/helloworld/app/v1")
public class AppController {

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
        mv.setViewName("/index");
        mv.addObject("title","欢迎来到我的个人空间!");
        return mv;
    }


    @PostMapping("/upload")
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadStatus");


        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String content = IOUtils.toString(bytes,"utf-8");
            log.info("content={}",content);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("fileName",file.getOriginalFilename());

        return modelAndView;
    }

}

