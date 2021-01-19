package com.example.demo.controller;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import com.example.demo.service.BlogService;
import com.example.demo.service.CommentService;
import com.example.demo.service.LogService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
//其他用户页
@RestController
@RequestMapping("/OtherUser")
public class OtherUserController extends BaseController{
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private BlogService blogService;
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private CommentService commentService;
    @Resource
    private  BlogMapper blogDao;
    //显示姓名  返回String
    @RequestMapping("/name")
    @ResponseBody
    public String showName(){
        return getOtherUser().getUser_name();
    }
    //显示队伍
    @RequestMapping("/team")
    @ResponseBody
    public String showTeam(){
        return teamMapper.queryByTeamId(getOtherUser().getTeam_id()).getTeam_department();
    }
    //显示学级
    @RequestMapping("/grade")
    @ResponseBody
    public Integer showGrade(){
        return getOtherUser().getUser_grade();
    }
    //显示图片
    @RequestMapping("/photo")
    @ResponseBody
    public String showPhoto(){
        return getOtherUser().getUser_photo();
    }
    //显示博客
    @RequestMapping("/blog")
    @ResponseBody
    public List<Blog> showBlog(){
        return blogMapper.queryByUserId(getOtherUser().getUser_id());
    }
    //点击对应文章进入 传参为点击的文章id（Integer） 返回跳转页面ModelAndView  /Blog/{bid}
    @ResponseBody
    @GetMapping(value = "/blog/{bid}")
    public ModelAndView read(@PathVariable Integer bid){
        setBlog(blogDao.queryByBlogId(bid));
        return new ModelAndView("/InBlog");
    }
    //退出  返回“/Blog”
    @RequestMapping("/exit")
    @ResponseBody
    public ModelAndView exit(){
        deleteOtherUser();
        return new ModelAndView("/Blog");
    }
}
