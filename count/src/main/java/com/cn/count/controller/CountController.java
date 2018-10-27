package com.cn.count.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CountController {

    @RequestMapping("/count")
    public  String count(){
        return "success";
    }
}
