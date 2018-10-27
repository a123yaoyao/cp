package com.cn.count.service;

import com.cn.count.model.User;

public interface UserService {

    User getUserByToken(String token);
}
