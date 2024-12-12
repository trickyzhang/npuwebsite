package com.zst.website416.controller;

import com.zst.website416.model.User;
import com.zst.website416.model.util.Result;
import com.zst.website416.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseBody
    public Result all() {
        List<User> userList = userService.getUserList();
        return Result.success(userList);
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        User foundUser = userService.findByName(user.getNickname());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return Result.success(foundUser);
        } else {
            return Result.fail("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        if (userService.isUsernameExists(user.getNickname())) {
            return Result.fail("用户名已存在");
        }
        userService.insert(user);
        return Result.success("注册成功");
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user) {
        userService.updateUserByNickname(user);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete/{nickname}")
    @ResponseBody
    public Result delete(@PathVariable String nickname) {
        userService.deleteUserByNickname(nickname);
        return Result.success("删除成功");
    }

}

