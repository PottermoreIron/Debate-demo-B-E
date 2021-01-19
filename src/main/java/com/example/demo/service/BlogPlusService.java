package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class BlogPlusService {

    private Blog blog;
    private String author_name;


    public BlogPlusService() {
    }





    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
