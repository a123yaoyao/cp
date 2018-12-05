package com.cn.count.controller;

import com.cn.count.model.TabelTree;

import com.cn.count.service.TableTreeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class TableController {

    @Autowired
    TableTreeService tableTreeService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/getTableTree")
    @ResponseBody
    public String getTableTree(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        boolean  hasKey = redisTemplate.hasKey("getTableTree");

        //缓存存在
        if(hasKey){
            String tabelTreeList = operations.get("getTableTree");
            return tabelTreeList;
        }else{
            List<TabelTree> list = tableTreeService.getTabelTree();
            String tabelTreeList =new Gson().toJson(list);
            System.out.println("==========从数据表中获得数据=========");

            System.out.println("==============================");
            //插入缓存
            operations.set("getTableTree", tabelTreeList,5,TimeUnit.MINUTES);
            return tabelTreeList;
        }


    }

    @RequestMapping("/getTableByName")
    @ResponseBody
    public String getTableByName(String tabelName){
        List<Map<String ,Object>> table = tableTreeService.getTableByName( tabelName);
        return new Gson().toJson(table);
    }

}
