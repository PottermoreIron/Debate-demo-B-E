package com.example.demo.controller;

import com.example.demo.pojo.Blog;
import com.example.demo.pojo.User;
import org.apache.shiro.authc.Account;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

public abstract class BaseController {

    private static final String USER="user";
    private static final String BLOG="blog";
    private static final String LIST="list";
    private static final String OTHER_USER="other_user";

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public User getUser() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(USER);
    }

    public void setUser(User user) {
        HttpSession session = getRequest().getSession();
        if (user != null) {
            session.setAttribute(USER, user);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
    public void deleteUser(){
        HttpSession session = getRequest().getSession();
        session.removeAttribute(USER);
    }

    public Blog getBlog() {
        HttpSession session = getRequest().getSession();
        return (Blog) session.getAttribute(BLOG);
    }

    public void setBlog(Blog blog) {
        HttpSession session = getRequest().getSession();
        if (blog != null) {
            session.setAttribute(BLOG, blog);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
    public void deleteBlog(){
        HttpSession session = getRequest().getSession();
        session.removeAttribute(BLOG);
    }

    public List<Blog> getList() {
        HttpSession session = getRequest().getSession();
        return (List<Blog>) session.getAttribute(LIST);
    }

    public void setList(List<Blog> list) {
        HttpSession session = getRequest().getSession();
        if (list != null) {
            session.setAttribute(LIST,list);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
    public void deleteList(){
        HttpSession session = getRequest().getSession();
        session.removeAttribute(LIST);
    }

    public User getOtherUser() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(OTHER_USER);
    }

    public void setOtherUser(User other_user) {
        HttpSession session = getRequest().getSession();
        if (other_user != null) {
            session.setAttribute(USER,other_user);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
    public void deleteOtherUser(){
        HttpSession session = getRequest().getSession();
        session.removeAttribute(OTHER_USER);
    }
}
