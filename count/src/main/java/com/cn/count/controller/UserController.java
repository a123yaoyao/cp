package com.cn.count.controller;

import com.cn.count.model.User;
import com.cn.count.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.Table;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("user/info")
    public String index(Model model,Long id) {
        User user =userService.findUserById(id);
        model.addAttribute("user", user);
        return "/admin-user";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("user/edit")
    public String toEdit(User user) {
        userService.edit(user);
        return "/admin-user";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "/admin-user";
    }


    @RequestMapping("/delete")
    public String delete(User user) {
        userService.delete(user);
        return "redirect:/list";
    }
}
