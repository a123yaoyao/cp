package com.cn.count.controller;

import com.cn.count.model.TabelTree;
import com.cn.count.model.pojo.TableTree;
import com.cn.count.service.TableTreeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    TableTreeService tableTreeService;

//    @RequestMapping("/getTableMenu")
//    @ResponseBody
//    public String getTableMenu(){
//
//        Gson gson =new Gson();
//        TableTree tableTree =new TableTree();
//        tableTree.setTitle("苹果公司");
//        tableTree.setType("folder");
//        List<TableTree> list =new ArrayList<>();
//        TableTree tableTree1 =new TableTree();
//        tableTree1.setTitle("iPhone");
//        tableTree1.setType("item");
//        list.add(tableTree1);
//        tableTree.setProducts(list);
//        List<TableTree> list1 =new ArrayList<>();
//        list1.add(tableTree);
//       return gson.toJson(list1);
//    }

    @RequestMapping("/getTableTree")
    @ResponseBody
    public String getTableTree(){

       List<TabelTree> list = tableTreeService.getTabelTree();
        return new Gson().toJson(list);
    }

}
