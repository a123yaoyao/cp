package com.cn.count.controller;

import com.cn.count.model.TabelTree;

import com.cn.count.service.TableTreeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TableController {

    @Autowired
    TableTreeService tableTreeService;



    @RequestMapping("/getTableTree")
    @ResponseBody
    public String getTableTree(){
       List<TabelTree> list = tableTreeService.getTabelTree();
        return new Gson().toJson(list);
    }

    @RequestMapping("/getTableByName")
    @ResponseBody
    public String getTableByName(String tabelName){
        List<Map<String ,Object>> table = tableTreeService.getTableByName( tabelName);
        return new Gson().toJson(table);
    }

}
