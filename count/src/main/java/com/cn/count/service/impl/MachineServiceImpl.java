package com.cn.count.service.impl;

import com.cn.count.service.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Service
@Slf4j
public class MachineServiceImpl implements MachineService {

    public  static  final String MB = "MB";

    @Override
    public Map<String,String> getCpuCondition() {
        return null;
    }

    @Override
    public Map<String, String> getHeapMemory() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Map<String, String>> future= pool.submit(new Callable<Map<String, String>>() {
            @Override
            public Map<String, String> call() throws Exception {
                Map<String,String> memory=new HashMap<>();
                MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

                MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

                long totalMemorySize = memoryUsage.getInit(); //初始的总内存

                long maxMemorySize = memoryUsage.getMax(); //最大可用内存

                long usedMemorySize = memoryUsage.getUsed(); //已使用的内存

                MemoryUsage noHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
                String totalNoHeapMemorySize = String.valueOf(noHeapMemoryUsage.getInit()/1024/1024.0)+MB;
                String maxNoHeapMemorySize =String.valueOf(noHeapMemoryUsage.getMax()/1024/1024.0)+MB;
                String usedNoHeapMemorySize = String.valueOf(noHeapMemoryUsage.getUsed()/1024/1024.0)+MB;

                memory.put("totalMemorySize",String.valueOf(totalMemorySize/1024/1024)+MB);
                memory.put("maxMemorySize",String.valueOf(maxMemorySize/1024/1024)+MB);
                memory.put("usedMemorySize",(String.valueOf(usedMemorySize/1024/1024)+MB));

                memory.put("totalNoHeapMemorySize",totalNoHeapMemorySize);
                memory.put("maxNoHeapMemorySize",maxNoHeapMemorySize);
                memory.put("usedNoHeapMemorySize",usedNoHeapMemorySize);
                log.info("Service 当前执行的线程为："+Thread.currentThread().getName());
                return  memory;
            }
        });

        return future.get();
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
