package com.cn.count.controller;

import com.cn.count.service.MachineService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.ExecutionException;

@RestController("/")
@Api("swaggerDemoController相关的api")
public class MachineController {

    Logger logger =LoggerFactory.getLogger(MachineController.class);

    @Autowired
    MachineService machineService;

    @ApiOperation(value="获取机器详细信息", notes="")
    @RequestMapping("/machine")
   public  String getMachineInfo(Model model) throws ExecutionException, InterruptedException {
        // 使用new方法
      Gson gson = new Gson();
      String machine =null;
      try {
           machine = gson.toJson(machineService.getHeapMemory());
      }catch (Exception e){
          return e.getLocalizedMessage();
      }
      //logger.info(machine);
      return machine;
    }
}
