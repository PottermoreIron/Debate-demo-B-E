package com.example.demo.service;

import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;

import java.util.List;

public interface IBlogService {
    String showBlog(Blog blog);
    String showTitle(Blog blog);
    int countUp(Blog blog);
    int countStar(Blog blog);
    void blogUp(Blog blog,User user);
    void blogStar(Blog blog,User user);
    void blogComment(String content,Blog blog,Integer comment_id);
    List<Comment> showComment(Blog blog);
    User blogAuthor(Blog blog);
    void updateBlog(Blog blog);
    List<Blog> showBlogByTime();
    List<Blog> showBlogByValue();
}
