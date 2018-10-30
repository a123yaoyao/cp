package com.cn.count.controller;

import com.cn.count.service.MachineService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@RestController("/")
public class MachineController {

    Logger logger =LoggerFactory.getLogger(MachineController.class);

    @Autowired
    MachineService machineService;

    @RequestMapping("/machine")
   public  String getMachineInfo(Model model){
        // 使用new方法
        Gson gson = new Gson();
      String machine=  gson.toJson(machineService.getHeapMemory())  ;
      logger.info(machine);
      return machine;
    }
}
