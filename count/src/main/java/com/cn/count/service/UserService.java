package com.cn.count.service;

import com.cn.count.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //通过令牌从sso系统获得用户
    User getUserByToken(String token);

    List<User> getUserList();

    User findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(User user);
}
