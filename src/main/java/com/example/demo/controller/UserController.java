package com.example.demo.controller;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.StarMapper;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//我的个人页
@RestController
@RequestMapping("/User")
public class UserController extends BaseController{
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private BlogService blogService;
    @Resource
    private BlogMapper blogDao;
    @Resource
    private CommentService commentService;
    @Resource
    private StarMapper starMapper;
    //显示姓名  返回String
    @RequestMapping("/name")
    @ResponseBody
    public String showName(@RequestParam Integer uid){
        return userMapper.queryByUserId(uid).getUser_name();
    }
    //显示队伍
    @RequestMapping("/team")
    @ResponseBody
    public String showTeam(@RequestParam Integer uid){
        return teamMapper.queryByTeamId(userMapper.queryByUserId(uid).getTeam_id()).getTeam_department();
    }
    //显示学级
    @RequestMapping("/grade")
    @ResponseBody
    public Integer showGrade(@RequestParam Integer uid){
        return userMapper.queryByUserId(uid).getUser_grade();
    }
    //显示头像
    @RequestMapping("/photo")
    @ResponseBody
    public String showPhoto(@RequestParam Integer uid){
        return userMapper.queryByUserId(uid).getUser_photo();
    }
    //修改姓名  传参String  无返回
    @RequestMapping("/changeName")
    @ResponseBody
    public void changeName(@RequestParam String new_name,@RequestParam Integer uid){
        User user=userMapper.queryByUserId(uid);
        user.setUser_name(new_name);
        userMapper.updateUser(user);
    }
    //修改头像  传参String  无返回
    @RequestMapping("/changePhoto")
    @ResponseBody
    public void changePhoto(@RequestParam String new_photo,@RequestParam Integer uid){
        User user=userMapper.queryByUserId(uid);
        user.setUser_photo(new_photo);
        userMapper.updateUser(user);
    }
    //修改密码  传参原密码String，新密码String   无返回
    @RequestMapping("/changePassword")
    @ResponseBody
    public boolean changePassword(@RequestParam String old_password,String new_password,@RequestParam Integer uid){
        if(old_password.equals(userMapper.queryByUserId(uid).getUser_password())){
            User user=userMapper.queryByUserId(uid);
            user.setUser_password(new_password);
            userMapper.updateUser(user);
            return true;
        }
        return false;

    }
    //显示博客  返回List
    @RequestMapping("/blog")
    @ResponseBody
    public List<BlogPlusService> showBlog(@RequestParam Integer uid){
        return showBlogPlus(blogDao.queryByUserId(uid));
    }
    //点击对应文章进入 传参为点击的文章id（Integer） 返回跳转页面ModelAndView  /Blog/{bid}
    @ResponseBody
    @GetMapping(value = "/blog/{bid}")
    public void read(@PathVariable Integer bid){
        setBlog(blogDao.queryByBlogId(bid));
    }
    //显示评论  返回List
    @RequestMapping("/showComment")
    @ResponseBody
    public List<Comment> showComment(@RequestParam Integer uid){
        return commentService.getCommentByUser1(uid);
    }
    //显示被评论  返回List
    @RequestMapping("/showCommented")
    @ResponseBody
    public List<Comment> showCommented(@RequestParam Integer uid){
        return commentService.getCommentByUser2(uid);
    }
    //退出  返回“/Login”
    @RequestMapping("/collect")
    @ResponseBody
    public List<BlogPlusService> showCollect(@RequestParam Integer uid){
        return showBlogPlus(userService.queryStar(userMapper.queryByUserId(uid)));
    }
    public List<BlogPlusService> showBlogPlus(List<Blog> list1){
        List<BlogPlusService> list2=new ArrayList<BlogPlusService>();
        for(Blog blog:list1){
            BlogPlusService blogPlusService=new BlogPlusService();
            blogPlusService.setAuthor_name(userMapper.queryByUserId(blog.getBlog_authorId()).getUser_name());
            blogPlusService.setBlog(blog);
            list2.add(blogPlusService);
        }
        return list2;
    }
    @RequestMapping("/exit")
    @ResponseBody
    public void exit(){

    }
}
