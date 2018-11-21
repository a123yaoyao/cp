package com.cn.count.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface MachineService {

   Map<String,String> getCpuCondition();

    Map<String, String> getHeapMemory() throws ExecutionException, InterruptedException;

    Map<String,String> getServerInfo();

    Map<String,String> getJvmInfo();



}
