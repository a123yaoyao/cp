package com.cn.count.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")

@Api("swaggerDemoController相关的api")
public class CountController {

    @RequestMapping("/")
    @ApiOperation(value="x", notes="")
    public  String count(){
        return "admin-index";
    }
}
