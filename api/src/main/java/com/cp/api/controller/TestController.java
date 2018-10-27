package com.cp.api.controller;
import com.cp.utils.helper.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("getDate")
    public String getDate(){

        System.out.println("测试");
        return  String.valueOf(BankCheck.checkBankCard("21212121111"));
    }
}
