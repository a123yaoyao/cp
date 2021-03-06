package com.cn.count.service.impl;

import com.cn.count.controller.MachineController;
import com.cn.count.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@Service
public class MachineServiceImpl implements MachineService {

    Logger logger = LoggerFactory.getLogger(MachineController.class);

    private final ConcurrentHashMap<String, Map<String,String>> cacheMap=new ConcurrentHashMap<> ();

    @Override
    public Map<String,String> getCpuCondition() {
        return null;
    }

    public   Object getCache(String key){
       Map<String,String> value=null;
        value = cacheMap.get(key);
        if(value==null){
            value = getHeapMemory();
           // cacheMap.putCache(key,value);
            cacheMap.putIfAbsent(key,value);
        }
        return value;
    }


//    public  void putCache(String key,Map<String,String> value){
//        cacheMap.putIfAbsent(key, value);
//    }

    @Override
    public Map<String,String> getHeapMemory() {


        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

        long totalMemorySize = memoryUsage.getInit(); //初始的总内存

        long maxMemorySize = memoryUsage.getMax(); //最大可用内存

        long usedMemorySize = memoryUsage.getUsed(); //已使用的内存
        Map<String,String> memory=new HashMap<>();
        dealWithMemorySize(totalMemorySize);
        memory.put("totalMemorySize",dealWithMemorySize(totalMemorySize));
        memory.put("maxMemorySize",dealWithMemorySize(maxMemorySize));
        memory.put("usedMemorySize",dealWithMemorySize(usedMemorySize));

        logger.info("查询");
        return memory;
    }

    private String dealWithMemorySize(long totalMemorySize) {

        if (totalMemorySize < 1024L){
            return totalMemorySize +"B";
        }
        if (totalMemorySize >=1024L &&totalMemorySize<1024*1024 ){
            return totalMemorySize/(1024l) +"kB";
        }
        if (totalMemorySize >=1024*1024 &&totalMemorySize< 1024*1024*1024 ){
            return totalMemorySize/(1024l*1024l) +"MB";
        }
        if (totalMemorySize >=1024l*1024l*1024l  ){
            return totalMemorySize/(1024l*1024l*1024l) +"TB";
        }
        return "";
    }

    @Override
    public Map<String,String> getServerInfo() {
        return null;
    }

    @Override
    public Map<String,String> getJvmInfo() {
        return null;
    }
}
