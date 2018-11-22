package com.cn.count.controller;

import com.cn.count.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2018/11/22/022 13:59
 * @Description:
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String index() {

        return "/login";
    }
}
