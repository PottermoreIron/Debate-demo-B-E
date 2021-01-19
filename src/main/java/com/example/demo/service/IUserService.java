package com.example.demo.service;

import com.example.demo.pojo.Blog;
import com.example.demo.pojo.User;

import java.util.List;

public interface IUserService {
    List<Blog> queryStar(User user);
    List<Blog> queryBlog(User user);
    String queryPhoto(User user);
    void changePhoto(User user,String photo);
    void changePassword(User user,String previous_password,String update_password);
    String queryName(User user);
    Integer queryTeam(User user);
}
