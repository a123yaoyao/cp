package com.cn.count;

import com.cn.count.model.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void insert() {
        User user =new User();
        user.setId(2l);
        user.setQq("291778952");
        mongoTemplate.save(user);
        log.info("插入成功");
    }

    @Test
    public void findAll() {
        List<User> userList = mongoTemplate.findAll(User.class);
        Gson gson =new Gson();
        String user =gson.toJson(userList);
        log.info("从mongo查到的用户为："+user);
    }
}
