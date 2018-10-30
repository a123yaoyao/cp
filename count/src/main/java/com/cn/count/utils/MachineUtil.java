package com.cn.count.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

public class MachineUtil {

    Runtime r = Runtime.getRuntime();
    Properties props = System.getProperties();
    InetAddress addr;
    Map<String, String> map = System.getenv();

    {
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    InetAddress  getAddr() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

    String getIp(){
        return addr.getHostAddress();
    }

    String getUserName(){
      return   map.get("USERNAME");
    }

//     String getTotalMemory(){
//        System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
//        return r.totalMemory();
//    }

}
