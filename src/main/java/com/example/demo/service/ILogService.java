package com.example.demo.service;

import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import java.util.List;

public interface ILogService {
    void reg(User user);
    boolean log(Integer uid,String password);
}
