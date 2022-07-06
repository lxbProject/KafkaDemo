package com.quectel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response){
        return "hello";
    }
}
