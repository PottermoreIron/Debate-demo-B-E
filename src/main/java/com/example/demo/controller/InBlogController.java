package com.example.demo.controller;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import com.example.demo.service.BlogService;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/InBlog")
public class InBlogController extends BaseController{
    @Resource
    private BlogService blogService;
    @Resource
    private BlogMapper blogDao;
    @Resource
    private CommentService commentService;
    @Resource
    private CommentMapper commentDao;
    @Resource
    private UserMapper userMapper;
    //显示当前访问博客  无传参  返回值为Blog    /InBlog
    @ResponseBody
    @RequestMapping("")
    public Blog show(){
        return getBlog();
    }
    //使当前赞状态改变被赞
    @ResponseBody
    @RequestMapping("/set_up")
    public void set_up(@RequestParam Integer uid,@RequestParam Integer bid){
         blogService.blogUp(blogDao.queryByBlogId(bid),userMapper.queryByUserId(uid));
    }
    //使当前博客收藏状态改变
    @ResponseBody
    @RequestMapping("/set_star")
    public void set_star(@RequestParam Integer uid,@RequestParam Integer bid){
         blogService.blogStar(blogDao.queryByBlogId(bid),userMapper.queryByUserId(uid));
    }
    //判断starlia
    @ResponseBody
    @RequestMapping("/if_star")
    public boolean if_star(@RequestParam Integer uid,@RequestParam Integer bid){
        return blogService.if_Star(blogDao.queryByBlogId(bid),userMapper.queryByUserId(uid));
    }
    @ResponseBody
    @RequestMapping("/if_up")
    public boolean if_up(@RequestParam Integer uid,@RequestParam Integer bid){
        return blogService.if_Up(blogDao.queryByBlogId(bid),userMapper.queryByUserId(uid));
    }
    //显示赞数  无传参  返回Integer  /InBlog/up
    @ResponseBody
    @RequestMapping("/up")
    public Integer up(@RequestParam Integer blog_id){
        return blogService.countUp(blogDao.queryByBlogId(blog_id));
    }
    //显示收藏数  无传参  返回Integer  /InBlog/star
    @ResponseBody
    @RequestMapping("/star")
    public Integer star(@RequestParam Integer blog_id){
        return blogService.countStar(blogDao.queryByBlogId(blog_id));
    }
    //显示作者  无传参  返回值为ModelAndView跳转到作者页    /Blog/author
    @ResponseBody
    @PostMapping("/author")
    public void author(){
        setOtherUser(userMapper.queryByUserId(getBlog().getBlog_authorId()));
    }
    //跳转至评论页，无传参，返回ModelAndView  /comment
    @ResponseBody
    @PostMapping("/comment")
    public void comment(){

    }
    //删除博客 无传参  无返回  /InBlog/delete
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(@RequestParam Integer bid,@RequestParam Integer cid){
        if(blogDao.queryByBlogId(bid).getBlog_authorId()==cid) {
            blogDao.deleteBlog(bid);
            return true;
        }
        return false;
    }
    //退出博客  返回首页ModelAndView
    @RequestMapping("/exit")
    @ResponseBody
    public void exit(){
    }
}
