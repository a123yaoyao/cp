package com.cn.count;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void InsertValue(){
        redisTemplate.opsForValue().set("sjkd","a");
        log.info("InsertValue success!");
    }

    @Test
    public void getValue(){
        String value= redisTemplate.opsForValue().get("sjkd");
        log.info("redis value = "+value);
        log.info("query success!");
    }

}
