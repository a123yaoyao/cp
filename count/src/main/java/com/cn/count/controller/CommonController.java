package com.cn.count.controller;

import com.cn.count.service.ParamService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2018/11/22/022 17:08
 * @Description:
 */
@Controller
public class CommonController {

    @Autowired
    ParamService paramService;

    @RequestMapping("param/list")
    @ResponseBody
    public String getParamList(){
        return new Gson().toJson(paramService.findAll()) ;
    }

    @RequestMapping("param/ParamPage")
    @ResponseBody
    public String getParamPage(){
        return new Gson().toJson(paramService.findPage()) ;
    }
}
