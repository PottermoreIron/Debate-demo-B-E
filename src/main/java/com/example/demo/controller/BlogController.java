package com.example.demo.controller;


import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.service.BlogPlusService;
import com.example.demo.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Blog")
public class BlogController extends BaseController{
    @Resource
    private BlogService blogService;
    @Resource
    private BlogMapper blogDao;
    @Resource
    private UserMapper userMapper;

    //按时间顺序逆序排序  无传参  返回值为List<Blog+username>  url:/Blog
    @ResponseBody
    @RequestMapping("")
    public List<BlogPlusService> showBlogByTime(){
        //如何展示界面？
        return showBlogPlus(blogService.showBlogByTime());
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
    //按价值顺序排序  无传参  返回值为List<Blog+username>  url:/Blog/show_by_value
    @ResponseBody
    @RequestMapping("/show_by_value")
    public List<BlogPlusService> showBlogByValue(){
        return showBlogPlus(blogService.showBlogByValue());
    }
    //发表博客 传参String标题，String内容  /Blog/publish
    @ResponseBody
    @RequestMapping("/publish")
    public void publish(@RequestParam String title,@RequestParam String text,@RequestParam Integer uid){
        Date date=new Date(System.currentTimeMillis());
        Blog blog=new Blog(blogDao.queryBlogList().get(blogDao.queryBlogList().size()-1).getBlog_id()+1,uid,date,text,title);
        blogService.updateBlog(blog);
        System.out.println("test");
    }
    //点击对应文章进入 传参为点击的文章id（Integer） 返回跳转页面ModelAndView  /Blog/{bid}
    @ResponseBody
    @GetMapping(value = "/{bid}")
    public void readByTime(@PathVariable Integer bid){
        setBlog(blogDao.queryByBlogId(bid));
    }
    //同上，只是针对价值排序显示   Integer 返回ModelAndView  /Blog/show_by_value/{bid}
    @ResponseBody
    @GetMapping(value = "/show_by_value/{bid}")
    public void readByValue(@PathVariable Integer bid){
        setBlog(blogDao.queryByBlogId(bid));
    }
    @ResponseBody
    @GetMapping(value="/select")
    public List<BlogPlusService> select(@RequestParam String select){
        System.out.println(select!= null && !select.trim().equals(""));
        if(select!= null && !select.trim().equals(""))
            return showBlogPlus(blogDao.selectBlog("%"+select+"%"));
        return showBlogByTime();
    }

}
