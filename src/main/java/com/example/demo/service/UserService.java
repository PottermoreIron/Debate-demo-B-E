package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.StarMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Star;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Resource
    private UserMapper userDao;
    @Resource
    private StarMapper starDao;
    @Resource
    private BlogMapper blogDao;
    @Override
    public List<Blog> queryStar(User user){
        List<Blog> user_blog=new ArrayList<Blog>();
        List<Star> user_star=starDao.queryByUserId(user.getUser_id());
        for(int i=0;i<user_star.size();i++){
            user_blog.add(blogDao.queryByBlogId(user_star.get(i).getStar_blogId()));
        }
        return user_blog;
    }
    @Override
    public List<Blog> queryBlog(User user){
        List<Blog> user_blog=new ArrayList<Blog>();
        user_blog=blogDao.queryByUserId(user.getUser_id());
        return user_blog;
    }
    @Override
    public String queryPhoto(User user){
        return user.getUser_photo();
    }
    @Override
    public void changePhoto(User user,String photo){
        user.setUser_photo(photo);
    }
    @Override
    public void changePassword(User user,String previous_password,String update_password){
        if(previous_password==user.getUser_password()){
            user.setUser_password(update_password);
        }
    }
    @Override
    public String queryName(User user){
        return user.getUser_name();
    }
    @Override
    public Integer queryTeam(User user){
        return user.getTeam_id();
    }

}
