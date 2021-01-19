package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogService implements ILogService{
    @Resource
    private UserMapper userDao;
    @Override
    public void reg(User user){
        userDao.addUser(user);
    }
    @Override
    public boolean log(Integer id,String password){
        if(userDao.queryByUserId(id)==null)
            return false;
        return password.equals(userDao.queryByUserId(id).getUser_password());
    }
}
