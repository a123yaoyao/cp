package com.cn.count.service.impl;

import com.cn.count.model.ResponseResult;
import com.cn.count.model.User;
import com.cn.count.repository.UserRepository;
import com.cn.count.service.UserService;
import com.cn.count.utils.HttpClientUtil;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@PropertySource(value = "classpath:resource.properties", ignoreResourceNotFound = true)
@Service
public class UserServiceImpl implements UserService {



    @Value("${SSO_BASE_URL}")
    public String SSO_BASE_URL;
    @Value("${SSO_DOMAIN_BASE_USRL}")
    public String SSO_DOMAIN_BASE_USRL;
    @Value("${SSO_PAGE_LOGIN}")
    public String SSO_PAGE_LOGIN;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Value("${SSO_USER_TOKEN}")
    private String SSO_USER_TOKEN;

   // @Autowired
  //  private UserRepository userRepository;


    @Override
    public User getUserByToken(String token) {
        try {
            // 调用sso系统的服务，根据token取用户信息
            String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
            logger.info("调用sso系统服务 返回的数据为： : " + json);
            // 把json转换成ItdragonResult
            ResponseResult result = ResponseResult.formatToPojo(json, User.class);
            if (null != result && result.getStatus() == 200) {
                User user = (User) result.getData();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<User> getUserList() {

        //return userRepository.findAll();
        return  new ArrayList<>();
    }

    @Override
    public User findUserById(long id) {

      //  return userRepository.findById(id);
        return new User();
    }

    @Override
    public void save(User user) {
//        userRepository
//                .save(user);
    }

    @Override
    public void edit(User user) {

        //userRepository.save(user);
    }

    @Override
    public void delete(User user) {

        //userRepository.delete(user);
    }

    @Override
    public User getUserByToken1(String token) {

        return new User();
    }


}
