package com.cn.count.service.impl;

import com.cn.count.service.MachineService;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MachineServiceImpl implements MachineService {
    @Override
    public Map<String,String> getCpuCondition() {
        return null;
    }

    @Override
    public Map<String,String> getHeapMemory() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

        long totalMemorySize = memoryUsage.getInit(); //初始的总内存

        long maxMemorySize = memoryUsage.getMax(); //最大可用内存

        long usedMemorySize = memoryUsage.getUsed(); //已使用的内存
        Map<String,String> memory=new HashMap<>();
        memory.put("totalMemorySize",String.valueOf(totalMemorySize/1024/1024)+"MB");
        memory.put("maxMemorySize",String.valueOf(maxMemorySize/1024/1024)+"MB");
        memory.put("usedMemorySize",(String.valueOf(usedMemorySize/1024/1024)+"MB"));

        return memory;
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
