package com.cn.count.service;

import java.util.List;
import java.util.Map;

public interface MachineService {

   Map<String,String> getCpuCondition();

    Map<String,String> getHeapMemory();

    Map<String,String> getServerInfo();

    Map<String,String> getJvmInfo();



}
