package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(Map<String,Object> map) {
        map.put("msg","你好");
        return "success";
    }
}
