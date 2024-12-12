package com.zst.website416.service;

import com.zst.website416.mapper.UserMapper;
import com.zst.website416.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(){
        return userMapper.findAll();
    }

    public User findByName(String nickname) {
        return userMapper.findByName(nickname);
    }

    public void insert(User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userMapper.insert(user);
    }

    public boolean isUsernameExists(String nickname) {
        return userMapper.existsByNickname(nickname);
    }

    public void updateUserByNickname(User user) {
        user.setUpdatedAt(new Date());
        userMapper.updateByNickname(user);
    }

    public void deleteUserByNickname(String nickname) {
        userMapper.deleteByName(nickname);
    }
}

